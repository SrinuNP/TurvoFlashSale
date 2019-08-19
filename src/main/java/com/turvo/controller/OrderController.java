package com.turvo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.turvo.dao.bean.Order;
import com.turvo.service.OrderService;
import com.turvo.service.ServicesException;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService = null;

	@PostMapping(path = "/placeOrder")
	public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
		try {
			orderService.save(order);
		} catch (ServicesException e) {
			e.printStackTrace();
			return new ResponseEntity<Order>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Order>(order, HttpStatus.OK);
	}

}
