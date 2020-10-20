package com.nosso.banco.controller;

import org.springframework.http.HttpStatus;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.nosso.banco.model.People;
import com.nosso.banco.repository.PeopleRepository;
import com.nosso.banco.service.Validation;

@RestController()
@RequestMapping("/people")
@CrossOrigin
public class PeopleController {

	@Autowired
	private PeopleRepository pessoaRepository;

	@Autowired
	private Validation validation;

	@RequestMapping()
	public String Home() {
		return "Hello Wolrd";
	}

	@PostMapping()
	public ResponseEntity<?> salvar(@Valid @RequestBody People pessoa, BindingResult result) {
		if (result.hasErrors()) {
			return new ResponseEntity<>(validation.handleValidationExceptions(result), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(pessoaRepository.save(pessoa), HttpStatus.CREATED);
	}

}
