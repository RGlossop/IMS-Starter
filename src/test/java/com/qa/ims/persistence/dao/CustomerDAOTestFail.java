package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.utils.DBUtils;

public class CustomerDAOTestFail {
	
	private final CustomerDAO dao = new CustomerDAO();

	@BeforeClass
	public static void init() {
		DBUtils.connect("root", "fail");
	}

	@Before
	public void setup() {
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void testCreateFail() {
		final Customer created = new Customer(3L, "chris", "perrins");
		assertEquals(null, dao.create(created));
	}
	
	@Test
	public void testReadAllFail() {
		assertEquals(new ArrayList<>(), dao.readAll());
	}
	
	@Test
	public void testReadLatestFail() {
		assertEquals(null, dao.readLatest());
	}
	
	@Test
	public void testReadCustomerFail() {
		final long id = 1l;
		assertEquals(null, dao.readCustomer(id));
	}
	
	@Test
	public void testUpdateFail() {
		final Customer created = new Customer(3L, "chris", "perrins");
		assertEquals(null, dao.update(created));
	}
	
	@Test
	public void testDeleteFail() {
		final long id = 1l;
		assertEquals(0, dao.delete(id));
	}
	
}
