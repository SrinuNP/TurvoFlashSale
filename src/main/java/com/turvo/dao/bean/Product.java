package com.turvo.dao.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="Product")
@Table
public class Product {
	
	@Id
	@Column(name="Product_Id")
	private Integer id = null;
	
	@Column(name="Product_Name")
	private String name = null;
	
	@Column(name="Product_Price")
	private Float price = null;
	
	@Column(name="Available_Count")
	private Integer count = null;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(Integer id, String name, Float price, Integer count) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.count = count;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}


	
}
