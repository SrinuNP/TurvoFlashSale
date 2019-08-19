package com.turvo.dao.bean;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.turvo.util.Status;

@Entity
@Table(name="Order_Details")
public class Order {

	
	@Id
	@Column(name = "Order_Id")
	private Integer id = null;
	
	@ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	@JoinColumn(name = "Product_Id")
	private Product product = null;
	
	@ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	@JoinColumn(name = "Buyer_Id")
	private Buyer buyer = null;
	
	@Column(name = "Created_At")
	private Date createdAt = null;
	
	@Enumerated(EnumType.STRING)
	@Column(name="Status")
	private Status status = null;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(Integer id, Product product, Buyer buyer, Date createdAt, Status status) {
		super();
		this.id = id;
		this.product = product;
		this.buyer = buyer;
		this.createdAt = createdAt;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	
	
}
