package com.turvo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turvo.dao.bean.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
