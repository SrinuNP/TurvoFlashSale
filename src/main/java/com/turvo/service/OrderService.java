package com.turvo.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turvo.dao.OrderRepository;
import com.turvo.dao.ProductRepository;
import com.turvo.dao.bean.Order;
import com.turvo.dao.bean.Product;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository = null;

	public Order getOrderById(Integer orderId) throws ServicesException {
		Order order = null;
		try {
			order = orderRepository.findById(orderId).get();
		} catch (Exception exp) {
			throw new ServicesException(exp.getMessage());
		}
		return order;
	}

	@Transactional(value = TxType.REQUIRED, rollbackOn = ServicesException.class)
	public void deleteOrderById(Integer orderId) throws ServicesException {
		try {
			orderRepository.deleteById(orderId);
		} catch (Exception exp) {
			throw new ServicesException(exp.getMessage());
		}
	}

	@Transactional(value = TxType.REQUIRED, rollbackOn = ServicesException.class)
	public void save(Order order) throws ServicesException {
		try {
			orderRepository.save(order);
		} catch (Exception exp) {
			throw new ServicesException(exp.getMessage());
		}
	}
}
