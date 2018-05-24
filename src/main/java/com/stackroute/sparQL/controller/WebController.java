package com.stackroute.sparQL.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.sparQL.repository.SparQLRepository;

@RestController
public class WebController {

	@Autowired
	private SparQLRepository repo;

	@RequestMapping(value = "/get")
	public String method() {
		repo.dummyMethod();
		return "this is page";

	}
}
