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
		List<Item> items = itemDAO.readAll();
		for (Item item: items) {
			LOGGER.info(item.toString());
		}
		return items;
	}

	/**
	 * Creates an Item by taking in user input
	 */
	@Override
	public Item create() {
		LOGGER.info("Please enter item name");
		String name = utils.getString();
		LOGGER.info("Please enter a price value (00.00)");
		Double value = utils.getDouble();
		Item item = itemDAO.create(new Item(name, value));
		LOGGER.info("Item Created");
		return item;
	}

	/**
	 * Updates an existing Item by taking in user input
	 */
	@Override
	public Item update() {
		readAll();
		LOGGER.info("Please enter the id of the item you would like to update");
		Long id = utils.getLong();
		LOGGER.info("Please enter its name");
		String name = utils.getString();
		LOGGER.info("Please enter its price");
		Double value = utils.getDouble();
		Item item = itemDAO.update(new Item(id, name, value));
		LOGGER.info("Item Updated");
		return item;
	}
	/**
	 * Deletes an existing Item by the id of the Item
	 * 
	 * @return
	 */
	@Override
	public int delete() {
		readAll();
		LOGGER.info("Please enter the id of the item you would like to delete");
		Long id = utils.getLong();
		return itemDAO.delete(id);
	}

}
