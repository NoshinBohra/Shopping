package com.example.Shopping.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Product")
public class Product implements Serializable {
	
	private static final long serialVersionUID = -3009157732242241606L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="type")
	private String type;
	
	@Column(name="size")
	private String size;
	
	@Column(name="price")
	private float price;
	
	@Column(name="avail")
	private String avail;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getAvail() {
		return avail;
	}

	public void setAvail(String avail) {
		this.avail = avail;
	}

	

	protected Product() {
	}
	
	public Product(String type, String size, float price, String avail) {
		this.type = type;
		this.size = size;
		this.price = price;
		this.avail = avail;
	}
	@Override
	public String toString() {
		return String.format("Product[id=%d, type='%s', size='%s', price='%f', avail='%s']", id, type, size, price, avail);
	}
	
}
