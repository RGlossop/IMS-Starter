package com.qa.ims;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.CustomerController;
import com.qa.ims.controller.ItemController;
import com.qa.ims.controller.OrderController;
import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class IMSTest {

	@Mock
	private CustomerController customers;
	
	@Mock
	private ItemController items;
	
	@Mock
	private OrderController orders;
	
	@Mock
	private Utils utils;

	@InjectMocks
	private IMS ims;
	
	@Test
	public void testConstruct() {
		CustomerDAO custDAO = new CustomerDAO();
		ItemDAO itemDAO = new ItemDAO();
		OrderDAO orderDAO = new OrderDAO();
		Utils utils = new Utils();
		
		ItemController iCTest = new ItemController(itemDAO, utils);
		CustomerController cCTest = new CustomerController(custDAO, utils);
		OrderController oCTest = new OrderController(orderDAO, utils, itemDAO, custDAO);
		IMS testIMS = new IMS(utils, cCTest, iCTest, oCTest);
		ims = new IMS();
		
		assertNotNull(ims);
		assertNotNull(testIMS);
	}
}
