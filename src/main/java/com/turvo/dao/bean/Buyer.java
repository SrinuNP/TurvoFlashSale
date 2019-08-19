package com.turvo.dao.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Buyer")
public class Buyer {
	
	@Id
	@Column(name="Buyer_Id")
	private Integer id = null;
	
	@Column(name="Buyer_Name")
	private String name = null;

	public Buyer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Buyer(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	
	
	

}
