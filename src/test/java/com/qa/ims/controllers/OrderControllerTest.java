package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.any;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.OrderController;
import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {
	
	@Mock
	private Utils utils;
	
	@Mock
	private OrderDAO dao;
	
	@Mock
	private CustomerDAO custDAO;
	
	@Mock
	private ItemDAO itemDAO;
	
	@InjectMocks
	private OrderController controller;
	
	@Test
	public void testCreate() {
		final Long custID = 1L;
		final Long quantity = 1L;
		final Long itemID = 1L;
		final String repeat = "no";
		final Item item = new Item(1L, "Borat", 15.50, 1L);
		List<Item> items = new ArrayList<Item>();
		items.add(item);
		Order created = new Order(1L, custID, items);
		created.setItems(items);
		Order expected = new Order(custID);
		
		
		Mockito.when(utils.getLong()).thenReturn(custID, quantity, itemID);
		Mockito.when(utils.getString()).thenReturn(repeat);
		Mockito.when(dao.create(expected)).thenReturn(created);
		Mockito.when(custDAO.readAll()).thenReturn(null);
		Mockito.when(itemDAO.readAll()).thenReturn(new ArrayList<>());
		
		assertEquals(created, controller.create());
		
		Mockito.verify(utils, Mockito.times(3)).getLong();
		Mockito.verify(utils, Mockito.times(1)).getString();
		Mockito.verify(dao, Mockito.times(1)).create(expected);
		
	}
	
	@Test
	public void testDelete() {
		final long ID = 1L;
		
		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(dao.delete(ID)).thenReturn(1);
		
		assertEquals(1L, this.controller.delete());
		
		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(ID);
	}
	
	@Test
	public void testUpdate() {
		final Long orderID = 1L;
		List<Item> startList = new ArrayList<Item>();
		Item startItem = new Item(1L, "Borat", 15.50, 1L);
		startList.add(startItem);
		Order start = new Order(1L, 1L, startList);
		
		List<Item> updateList = new ArrayList<Item>();
		Item newItem = new Item(2L, "John", 30.30, 1L);
		updateList.add(startItem);
		updateList.add(newItem);
		Order updated = new Order(1L, 1L, updateList);
		
		
	    
		Mockito.when(utils.getLong()).thenReturn(1L);
		Mockito.when(dao.readAll()).thenReturn(new ArrayList<>());
		Mockito.when(dao.readOrder(orderID)).thenReturn(start, start, start, updated);
		Mockito.when(utils.getString()).thenReturn("Delete", "add", "fail", "exit");
		Mockito.when(dao.deleteOrderItem(any(), any())).thenReturn(0);
		Mockito.when(itemDAO.readAll()).thenReturn(startList);
		assertEquals(updated, controller.update());
		
		Mockito.verify(utils, Mockito.times(4)).getLong();
		Mockito.verify(utils, Mockito.times(4)).getString();
		Mockito.verify(dao, Mockito.times(1)).readAll();
		Mockito.verify(dao, Mockito.times(6)).readOrder(any());
		Mockito.verify(dao, Mockito.times(1)).deleteOrderItem(any(), any());
		Mockito.verify(itemDAO, Mockito.times(1)).readAll();
	}

}
