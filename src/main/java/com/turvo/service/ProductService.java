package com.turvo.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turvo.dao.ProductRepository;
import com.turvo.dao.bean.Product;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository = null;

	public Product getProductById(Integer productId) throws ServicesException {
		Product product = null;
		try {
			product = productRepository.findById(productId).get();
		} catch (Exception exp) {
			throw new ServicesException(exp.getMessage());
		}
		return product;
	}

	@Transactional(value = TxType.REQUIRED, rollbackOn = ServicesException.class)
	public void deleteProductById(Integer productId) throws ServicesException {
		try {
			productRepository.deleteById(productId);
		} catch (Exception exp) {
			throw new ServicesException(exp.getMessage());
		}
	}

	@Transactional(value = TxType.REQUIRED, rollbackOn = ServicesException.class)
	public void saveOrUpdate(Product product) throws ServicesException {
		try {
			productRepository.saveAndFlush(product);
		} catch (Exception exp) {
			throw new ServicesException(exp.getMessage());
		}
	}
}
