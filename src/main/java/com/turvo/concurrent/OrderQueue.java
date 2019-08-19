package com.turvo.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.turvo.dao.bean.Order;
import com.turvo.dao.bean.Product;
import com.turvo.service.OrderService;
import com.turvo.service.ProductService;
import com.turvo.service.RegistrationService;
import com.turvo.service.ServicesException;
import com.turvo.util.Status;

@Component
public class OrderQueue {
	private final Lock queueLock = new ReentrantLock();

	@Autowired
	private OrderService orderService = null;

	@Autowired
	private ProductService productService = null;

	@Autowired
	private RegistrationService registrationService = null;

	public void placeOrder(Order order) throws ServicesException {
		queueLock.lock();
		try {
			if (registrationService.getRegistrationById(1).getStatus().toString().equals(Status.OPEN.toString())) {
				Product product = productService.getProductById(order.getProduct().getId());
				if (product.getCount() > 0) {
					orderService.save(order);
					product.setCount(product.getCount() - 1);
					productService.saveOrUpdate(product);
					System.out.println(Thread.currentThread().getName() + " :: Order Placed Successfully");
				} else {
					System.out.println(Thread.currentThread().getName() + " :: Sorry !!! Out of stock ");
				}
			}
		} catch (ServicesException e) {
			throw new ServicesException(e.getMessage());
		} finally {
			System.out.printf("%s: The document has been printed\n", Thread.currentThread().getName());
			queueLock.unlock();
		}
	}
}
