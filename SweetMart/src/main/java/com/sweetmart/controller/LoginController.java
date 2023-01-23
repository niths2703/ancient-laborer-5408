package com.sweetmart.controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sweetmart.dto.LoginDTO;
import com.sweetmart.exception.LoginException;
import com.sweetmart.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	private LoginService customerLogin; 
	
	@PostMapping("/login")
	public ResponseEntity<String> logInCustomer(@Valid @RequestBody LoginDTO dto) throws LoginException {
		String result = customerLogin.logIntoAccount(dto);
		
		return new ResponseEntity<String>(result,HttpStatus.OK );
	}
	
	@PostMapping("/logout")
	public String logoutCustomer(@RequestParam(required = false) String key) throws LoginException {
		
		return customerLogin.logOutFromAccount(key);
	}
	
	
	
	
	
	
	
}
