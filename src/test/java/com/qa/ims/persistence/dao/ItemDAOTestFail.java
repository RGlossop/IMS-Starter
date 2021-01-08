package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class ItemDAOTestFail {
	private final ItemDAO dao = new ItemDAO();

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
		final Item created = new Item(2L, "Borat Subsequent Moviefilm", 20.00);
		assertEquals(null, dao.create(created));
	}
	
	@Test
	public void testReadLatestFail() {
		assertEquals(null, dao.readLatest());
	}
	
	@Test
	public void testReadItemFail() {
		final long ID = 1l;
		assertEquals(null, dao.readItem(ID));
	}
	
	@Test
	public void testReadAllFail() {
		assertEquals(new ArrayList<>(), dao.readAll());
	}
	
	@Test
	public void testUpdateFail() {
		final Item created = new Item(2L, "Borat Subsequent Moviefilm", 20.00);
		assertEquals(null, dao.update(created));
	}
	
	@Test
	public void testDeleteFail() {
		final long ID = 1l;
		assertEquals(0, dao.delete(ID));
	}
}
