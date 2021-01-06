package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAOTestFail {
	private final OrderDAO dao = new OrderDAO();
	
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
		final List<Item> items = new ArrayList<Item>();
		final Order created = new Order(2L, 1L, items);
		assertEquals(null, dao.create(created));
	}
	
	@Test
	public void testReadOrderFail() {
		final long ID = 1l;
		assertEquals(null, dao.readOrder(ID));
	}
	
	@Test
	public void testReadItemsFail() {
		final long ID = 1l;
		assertEquals(null, dao.readItems(ID));
	}
	
	@Test
	public void testReadLatestFail() {
		assertEquals(null, dao.readLatest());
	}
	
	@Test
	public void testReadAllFail() {
		assertEquals(new ArrayList<>(), dao.readAll());
	}
	
	@Test
	public void testUpdateFail() {
		final List<Item> items = new ArrayList<Item>();
		final Order created = new Order(2L, 1L, items);
		assertEquals(null, dao.update(created));
	}
	
	@Test
	public void testDeleteFail() {
		final long ID = 1l;
		assertEquals(0, dao.delete(ID));
	}
	
	@Test
	public void testDeleteOrderItemsFail() {
		final long ID = 1l;
		assertEquals(0, dao.deleteOrderItems(ID));
	}
	
	@Test
	public void testDeleteOrderItemFail() {
		final long ID = 1l;
		assertEquals(0, dao.deleteOrderItem(ID, ID));
	}
	
	@Test
	public void testAddOrderItemsFail() {
		final long ID = 1l;
		dao.addOrderItems(ID,ID,ID);
	}
	
}
