package com.turvo.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turvo.dao.RegistrationRepository;
import com.turvo.dao.bean.Product;
import com.turvo.dao.bean.Registration;

@Service
public class RegistrationService {

	@Autowired
	private RegistrationRepository registrationRepository = null;

	@Transactional(value = TxType.REQUIRED, rollbackOn = ServicesException.class)
	public void save(Registration registration) throws ServicesException {
		try {
			registrationRepository.save(registration);
		} catch (Exception exp) {
			throw new ServicesException(exp.getMessage());
		}
	}

	public Registration getRegistrationById(Integer registrationId) throws ServicesException {
		Registration registration = null;
		try {
			registration = registrationRepository.findById(registrationId).get();
		} catch (Exception exp) {
			throw new ServicesException(exp.getMessage());
		}
		return registration;
	}
}
