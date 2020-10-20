package com.nosso.banco.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nosso.banco.model.Address;
import com.nosso.banco.model.People;
import com.nosso.banco.repository.AddressRepository;
import com.nosso.banco.repository.PeopleRepository;
import com.nosso.banco.service.Validation;

@RestController
@RequestMapping("/address")
@CrossOrigin
public class AddressController {

	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private PeopleRepository peopleRepository;
	
	
	@Autowired
	private Validation validation;

	
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Address address,BindingResult result) {
		if (result.hasErrors()) {
			return new ResponseEntity<>(validation.handleValidationExceptions(result), HttpStatus.BAD_REQUEST);
		}
		
	   Optional<People> people = peopleRepository.findById(address.getPeople_id());
	   if(people.isEmpty()) {
		   return new ResponseEntity<>("need to inform the customer registration before", HttpStatus.BAD_REQUEST);
		   
	   }
		
		return new ResponseEntity<>(addressRepository.save(address), HttpStatus.CREATED);
	}
	
	
	
}
