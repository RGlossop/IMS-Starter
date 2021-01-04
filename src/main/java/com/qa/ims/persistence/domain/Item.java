package com.qa.ims.persistence.domain;

public class Item {

	private Long id;
	private String name;
	private Double value;
	private Long quantity= null;

	public Item(String name, Double value) {
		this.name = name;
		this.value = value;
	}

	public Item(Long id, String name, Double value) {
		this.id = id;
		this.name = name;
		this.value = value;
	}

	public Item (Long id, String name, Double value, Long quantity) {
		this.id = id;
		this.name = name;
		this.value = value;
		this.quantity = quantity;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		if (quantity != null) {
			return "item_id:" + id + " name:" + name + ",  value:" + value + ", quantity: " + quantity + " ";
		}
		return "id:" + id + " name:" + name + " value:" + value;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

}
