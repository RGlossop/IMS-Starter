package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	private OrderDAO orderDAO;
	private ItemDAO itemDAO;
	private Utils utils;
	
	public OrderController(OrderDAO orderDAO, Utils utils, ItemDAO itemDAO) {
		super();
		this.orderDAO = orderDAO;
		this.itemDAO = itemDAO;
		this.utils = utils;
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
		// TODO Auto-generated method stub
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
