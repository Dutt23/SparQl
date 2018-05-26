package com.stackroute.sparQL.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.stackroute.sparQL.model.Questions;
import com.stackroute.sparQL.repository.SparQLRepository;

@RestController
public class WebController {

	@Autowired
	private SparQLRepository repo;

	@RequestMapping(value = "/get")
	public String method(Questions questions) throws JsonParseException, JsonMappingException, IOException {
		repo.presidents(questions);
		return "this is page";
	}
}
