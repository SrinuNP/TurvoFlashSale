package com.turvo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turvo.dao.bean.Registration;

@Repository	
public interface RegistrationRepository extends JpaRepository<Registration, Integer> {

}
