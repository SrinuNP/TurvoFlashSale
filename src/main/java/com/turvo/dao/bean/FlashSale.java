package com.turvo.dao.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Flash_Sale")
public class FlashSale {
	
	@Id
	@Column(name = "Id")
	private Integer id = null;
	
	@OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	@JoinColumn(name = "Product_Id")
	private Product product = null;

	public FlashSale() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FlashSale(Integer id, Product product) {
		super();
		this.id = id;
		this.product = product;
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
	
	

}
