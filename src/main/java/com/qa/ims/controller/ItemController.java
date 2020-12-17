package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

/**
 * Takes in Item details for CRUD functionality
 *
 */
public class ItemController implements CrudController<Item>{
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	private ItemDAO itemDAO;
	private Utils utils;
	
	public ItemController(ItemDAO itemDAO, Utils utils) {
		super();
		this.itemDAO = itemDAO;
		this.utils = utils;
	}
	/**
	 * Reads all Items to the logger
	 */
	@Override
	public List<Item> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Creates an Item by taking in user input
	 */
	@Override
	public Item create() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Updates an existing Item by taking in user input
	 */
	@Override
	public Item update() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Deletes an existing Item by the id of the Item
	 * 
	 * @return
	 */
	@Override
	public int delete() {
		// TODO Auto-generated method stub
		return 0;
	}

}
