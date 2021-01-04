package com.qa.ims.persistence.domain;

import java.util.List;

public class Order {
	private Long id;
	private Long cust_ID;
	private List<Item> items;

	public Order(Long cust_ID, List<Item> items) {
		this.cust_ID = cust_ID;
		this.items = items;
	}
	public Order(Long id, Long cust_ID, List<Item> items) {
		this.id = id;
		this.cust_ID = cust_ID;
		this.items = items;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCust_ID() {
		return cust_ID;
	}
	public void setCust_ID(Long cust_ID) {
		this.cust_ID = cust_ID;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	@Override
	public String toString() {
		double totalPrice = 0;
		String itemString = "\n";
		for (Item item : items) {
			totalPrice += (item.getValue() * item.getQuantity());
			itemString += item.toString() + "\n";
		}
		return "\nOrder id=" + id + ", cust_ID=" + cust_ID + ", items;" + itemString + "Total Price = £" + totalPrice + "\n";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (cust_ID == null) {
			if (other.cust_ID != null)
				return false;
		} else if (!cust_ID.equals(other.cust_ID))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		return true;
	}
	
}
