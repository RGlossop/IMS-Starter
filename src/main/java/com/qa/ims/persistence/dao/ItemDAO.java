package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class ItemDAO implements Dao<Item>{

	
	@Override
	public Item modelFromResultSet(ResultSet resultSet) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Reads all Items from the database
	 * 
	 * @return A list of Items
	 */
	@Override
	public List<Item> readAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Creates an Item in the database
	 * 
	 * @param item - takes in a Item object. id will be ignored
	 */
	@Override
	public Item create(Item t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Updates an Item in the database
	 * 
	 * @param item - takes in an item object, the id field will be used to
	 *                 update that item in the database
	 * @return
	 */
	@Override
	public Item update(Item t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Deletes an item in the database
	 * 
	 * @param id - id of the item
	 */
	@Override
	public int delete(long id) {
		// TODO Auto-generated method stub
		return 0;
	}



}
