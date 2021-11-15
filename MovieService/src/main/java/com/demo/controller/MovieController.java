package com.demo.controller;

import java.util.List;

import org.hibernate.EntityMode;
import org.hibernate.boot.jaxb.hbm.internal.EntityModeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entities.Movie;
import com.demo.services.MovieService;

@RestController
public class MovieController {
	
	@Autowired
	private MovieService movService;
	
	@GetMapping("/api/movie")
	public ResponseEntity getAllEmp(){
		
		return new ResponseEntity(movService.getAllMov(), HttpStatus.OK);
	}
	
//	@GetMapping("/api/employees/{id}")
//	public Movie getMov(@PathVariable("id") int id){
//
//    }

}
