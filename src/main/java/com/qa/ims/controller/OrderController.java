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
	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDAO.readAll();
		for(Order order : orders) {
			LOGGER.info(order.toString());
		}
		return orders;
	}

	@Override
	public Order create() {
		customerDAO.readAll();
		LOGGER.info("please enter the customers ID");
		long custID = utils.getLong();
		Order order = orderDAO.create(new Order(custID));
		String repeat;
		do {
			List<Item> items = itemDAO.readAll();
			for (Item item: items) {
				LOGGER.info(item.toString());
			}
			LOGGER.info("please enter the item ID to add");
			long itemID = utils.getLong();
			orderDAO.addOrderItems(order.getId(), itemID);
			LOGGER.info("Would you like to add another?");
			repeat = utils.getString();
		} while (repeat.toLowerCase().equals("yes"));
		return null;
	}

	@Override
	public Order update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete() {
		readAll();
		LOGGER.info("please enter the id of the order you would like to delete");
		Long id = utils.getLong();
		orderDAO.deleteOrderItems(id);
		return orderDAO.delete(id);
	}

}
