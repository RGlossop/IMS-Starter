package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class OrderTest {

	final List<Item> items = new ArrayList<Item>();
	
	@Test
	public void testSetID() {
		final Long idUpdate = 2L;
		Order expected = new Order(idUpdate, 1L, items);
		Order toUpdate = new Order(1L, 1L, items);
		
		toUpdate.setId(idUpdate);
		
		assertEquals(expected, toUpdate);
	}
	
	@Test
	public void testSetCustID() {
		final Long idUpdate = 2L;
		Order expected = new Order(idUpdate, items);
		Order toUpdate = new Order(1L, items);
		
		toUpdate.setCust_ID(idUpdate);
		
		assertEquals(expected, toUpdate);
	}
	
	@Test
	public void testGetItems() {
		Order expected = new Order(1L, items);
		
		assertEquals(expected.getItems(), items);
	}
}
