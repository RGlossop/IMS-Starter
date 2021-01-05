package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	private OrderDAO orderDAO;
	private ItemDAO itemDAO;
	private CustomerDAO customerDAO;
	private Utils utils;
	
	public OrderController(OrderDAO orderDAO, Utils utils, ItemDAO itemDAO, CustomerDAO customerDAO) {
		super();
		this.orderDAO = orderDAO;
		this.itemDAO = itemDAO;
		this.utils = utils;
		this.customerDAO = customerDAO;
	}
	/**
	 * Reads all orders to the logger
	 */
	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDAO.readAll();
		for(Order order : orders) {
			LOGGER.info(order.toString());
		}
		return orders;
	}
	/**
	 * Creates an Order by taking in user input
	 */
	@Override
	public Order create() {
		customerDAO.readAll();
		LOGGER.info("please enter the customers ID");
		Long custID = utils.getLong();
		Order order = orderDAO.create(new Order(custID));
		String repeat;
		do {
			List<Item> items = itemDAO.readAll();
			for (Item item: items) {
				LOGGER.info(item.toString());
			}
			LOGGER.info("please enter the item ID to add");
			Long itemID = utils.getLong();
			LOGGER.info("Please enter a quantity to add");
			Long quantity = utils.getLong();
			orderDAO.addOrderItems(order.getId(), itemID, quantity);
			LOGGER.info("Would you like to add another?");
			repeat = utils.getString();
		} while (repeat.toLowerCase().equals("yes"));
		return null;
	}
	/**
	 * Updates an existing Order by taking in user input
	 */
	@Override
	public Order update() {
		Long id = null;
		Order order = null;
		do {
			readAll();
			LOGGER.info("Please enter the id of the order you want to update");
			id = utils.getLong();
			order = orderDAO.readOrder(id);
		} while (order == null);
		boolean exit = false;
		do {
			order = orderDAO.readOrder(id);
			LOGGER.info(order.toString());
			LOGGER.info("Add or delete an item? exit to go back");
			String selection = utils.getString().toLowerCase();
			Long itemID;
			switch (selection) {
			case "delete":
				LOGGER.info("please enter item id to delete");
				itemID = utils.getLong();
				orderDAO.deleteOrderItem(order.getId(), itemID);
				break;
			case "add":
				List<Item> items = itemDAO.readAll();
				for (Item item : items) {
					LOGGER.info(item.toString());
				}
				LOGGER.info("Please enter the item id to add");
				itemID = utils.getLong();
				LOGGER.info("Please enter a quantity to add");
				Long quantity = utils.getLong();
				orderDAO.addOrderItems(order.getId(), itemID, quantity);
				break;
			case "exit":
				exit = true;
				break;
			default:
				LOGGER.info("Invalid selection");
				break;
			}
		} while (!exit);
		return orderDAO.readOrder(id);
	}
	/**
	 * Deletes an existing order by the id.
	 * 
	 * @param id- id of the order
	 */
	@Override
	public int delete() {
		readAll();
		LOGGER.info("please enter the id of the order you would like to delete");
		Long id = utils.getLong();
		orderDAO.deleteOrderItems(id);
		return orderDAO.delete(id);
	}

}
