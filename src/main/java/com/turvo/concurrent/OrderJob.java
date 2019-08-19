package com.turvo.concurrent;

import com.turvo.dao.bean.Order;
import com.turvo.service.ServicesException;

public class OrderJob implements Runnable {
	private OrderQueue orderQueue = null;
	private Order order = null;

	public OrderJob(OrderQueue orderQueue, Order order) {
		this.orderQueue = orderQueue;
		this.order = order;
	}

	@Override
	public void run() {
		try {
			orderQueue.placeOrder(order);
		} catch (ServicesException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}