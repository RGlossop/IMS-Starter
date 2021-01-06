package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CustomerTest {
	
	@Test
	public void testSetID() {
		final Long idUpdate = 2L;
		Customer expected = new Customer(idUpdate, "dave", "davidson");
		Customer toUpdate = new Customer(1L, "dave", "davidson");
		
		toUpdate.setId(idUpdate);
		
		assertEquals(expected, toUpdate);
	
	}
	
	@Test
	public void testSetFirstName() {
		final String nameUpdate = "John";
		Customer expected = new Customer(1L, nameUpdate, "davidson");
		Customer toUpdate = new Customer(1L, "dave", "davidson");
		
		toUpdate.setFirstName(nameUpdate);
		
		assertEquals(expected, toUpdate);
	}
	
	@Test
	public void testSetSurname() {
		final String nameUpdate = "Johnson";
		Customer expected = new Customer(1L, "dave", nameUpdate);
		Customer toUpdate = new Customer(1L, "dave", "davidson");
		
		toUpdate.setSurname(nameUpdate);
		
		assertEquals(expected, toUpdate);
	}
	
}
