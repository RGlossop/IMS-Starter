package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ItemTest {

	
	@Test
	public void testSetName() {
		final String nameUpdate = "Borat 2";
		Item expected = new Item(1L, nameUpdate, 15.50);
		Item toUpdate = new Item(1L, "Borat", 15.50);
		
		toUpdate.setName(nameUpdate);
		
		assertEquals(expected, toUpdate);
	}
	
	@Test
	public void testSetID() {
		final Long idUpdate = 2L;
		Item expected = new Item(idUpdate, "Borat", 15.50);
		Item toUpdate = new Item(1L, "Borat", 15.50);
		
		toUpdate.setId(idUpdate);
	
		assertEquals(expected, toUpdate);
	}
	
	@Test
	public void testSetValue() {
		final double valueUpdate = 30.00;
		Item expected = new Item(1L, "Borat", valueUpdate);
		Item toUpdate = new Item(1L, "Borat", 15.50);
		
		toUpdate.setValue(valueUpdate);
	
		assertEquals(expected, toUpdate);
	}
}
