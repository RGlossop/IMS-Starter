package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAOTest {
	private final OrderDAO dao = new OrderDAO();
	
	@BeforeClass
	public static void init() {
		DBUtils.connect("root", "root");
	}
	
	@Before
	public void setup() {
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}
	
	@Test
	public void testCreate() {
		final List<Item> items = new ArrayList<Item>();
		final Order created = new Order(2L, 1L, items);
		assertEquals(created, dao.create(created));
	}
	
	@Test
	public void testReadOrder() {
		final long ID = 1l;
		List<Item> items = new ArrayList<Item>();
		Item item = new Item(1L, "Borat", 15.50);
		items.add(item);
		Order expected = new Order(1L, 1L, items);
		
		assertEquals(expected, dao.readOrder(ID));
	}
	
	@Test
	public void testReadAll() {
		List<Order> expected = new ArrayList<Order>();
		List<Item> items = new ArrayList<Item>();
		Item item = new Item(1L, "Borat", 15.50);
		items.add(item);
		Order order = new Order(1L, 1L, items);
		expected.add(order);
		
		assertEquals(expected, dao.readAll());
	}
	
	@Test
	public void testDelete() {
		assertEquals(1, dao.deleteOrderItems(1L));
		assertEquals(1, dao.delete(1));
	}
	
	@Test
	public void testDeleteItem() {
		assertEquals(1, dao.deleteOrderItem(1L, 1L));
	}
	
	@Test
	public void testAddOrderItems() {
		final long ID = 1l;
		List<Order> expected = new ArrayList<Order>();
		List<Item> items = new ArrayList<Item>();
		Item item = new Item(1L, "Borat", 15.50);
		item.setQuantity(1L);
		items.add(item);
		items.add(item);
		Order order = new Order(1L, 1L, items);
		expected.add(order);
		
		dao.addOrderItems(1L, 1L, 1L);
		
		Order newOrder = dao.readOrder(ID); 
		assertEquals(order, newOrder);
	}
	
	@Test
	public void testUpdate() {
		List<Item> items = new ArrayList<Item>();
		Item item = new Item(1L, "Borat", 15.50, 1L);
		items.add(item);
		Order expected = new Order(1L, 1L, items);
		
		assertEquals(expected, dao.update(expected));
	}
}
