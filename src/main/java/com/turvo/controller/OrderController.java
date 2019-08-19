package com.turvo.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.turvo.concurrent.OrderJob;
import com.turvo.concurrent.OrderQueue;
import com.turvo.dao.bean.Order;
import com.turvo.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderQueue orderQueue = null;

	@Autowired
	private OrderService orderService = null;

	@PostMapping(path = "/placeOrder")
	public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
		try {
			new Thread(new OrderJob(orderQueue, order)).start();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Order>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Order>(order, HttpStatus.OK);
	}

	@GetMapping(path = "/orders/{orderId}")
	public ResponseEntity<Order> getOrder(@PathParam("orderId") Integer orderId) {
		Order order = new Order();
		try {
			order = orderService.getOrderById(orderId);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Order>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Order>(order, HttpStatus.OK);
	}

}
