package com.turvo.dao.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.turvo.util.Status;

@Entity
@Table(name="Registration")
public class Registration {
	
	@Id
	@Column(name = "Id")
	private Integer id = null;
	
	@OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	@JoinColumn(name = "FlashSale_ID")
	private FlashSale flashSale = null;
	
	@Enumerated(EnumType.STRING)
	@Column(name="Status")
	private Status status = null;

	public Registration() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Registration(Integer id, FlashSale flashSale, Status status) {
		super();
		this.id = id;
		this.flashSale = flashSale;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public FlashSale getFlashSale() {
		return flashSale;
	}

	public void setFlashSale(FlashSale flashSale) {
		this.flashSale = flashSale;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	

}
