package com.nosso.banco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.nosso.banco.service.Disco;

@RestController
@RequestMapping("/photos")
@CrossOrigin
public class imageController {
  
	@Autowired
    private Disco disco;

	
	@PostMapping
	public void upload (@RequestParam MultipartFile photo,@RequestParam int people_id){
	 	disco.salvarFoto(photo, people_id);
	}
	
}
