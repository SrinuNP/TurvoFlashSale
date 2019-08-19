package com.turvo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.turvo.dao.bean.Registration;
import com.turvo.service.RegistrationService;
import com.turvo.service.ServicesException;

@RestController
public class RegisterController {

	@Autowired
	private RegistrationService registrationService = null;

	@PostMapping(path = "/registerFlashSale")
	public ResponseEntity<HttpStatus> registerFlashSale(@RequestBody Registration registration) {

		try {
			registrationService.save(registration);
		} catch (ServicesException e) {
			e.printStackTrace();
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

}
