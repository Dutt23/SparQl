package com.stackroute.sparQL.repository;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.ResultSetFormatter;
import com.stackroute.sparQL.model.Main;
import com.stackroute.sparQL.model.Questions;

@Repository
public class SparQLRepository {

	@Autowired
	QuestionsRepository repo;

	public Questions capitals(Questions questions) throws JsonParseException, JsonMappingException, IOException {

		String sparqlQuery = "PREFIX dbo: <http://dbpedia.org/ontology/>\n"
				+ "PREFIX dbr: <http://dbpedia.org/resource/>\n" + "\n" + "SELECT DISTINCT ?country ?capital\n"
				+ "WHERE {\n" + " ?country a dbo:Country.\n" + " ?country dbo:capital ?capital.\n" + "} \n "
				+ "LIMIT 50";
EndPoint sp = new EndPoint();
		Query query = QueryFactory.create(sparqlQuery);
		QueryExecution queryExecution = QueryExecutionFactory.sparqlService("http://dbpedia.org/sparql", query);
		ResultSet result = queryExecution.execSelect();

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ResultSetFormatter.outputAsJSON(outputStream, result);
		String json = new String(outputStream.toByteArray()).replace("http://dbpedia.org/resource/", " ");
		
		ObjectMapper objectMapper = new ObjectMapper();
		Main main = objectMapper.readValue(json, Main.class);

		String questionStem = "What is capital of ";
		Random rand = new Random();
		int i = rand.nextInt(main.getResults().getBindings().size()) + 1;
		int j = rand.nextInt(main.getResults().getBindings().size()) + 1;
		int k = rand.nextInt(main.getResults().getBindings().size()) - 3;
		for (int c = 0; c < main.getResults().getBindings().size(); c++) {
			questions.setQuestionId(c + 1);
			questions.setQuestionStem(
					questionStem + main.getResults().getBindings().get(c).getCountry().getValue() + "?");
			questions.setQuestionLevel(1);
			questions.setQuestionType("Auto");
			questions.setOption1(main.getResults().getBindings().get(i).getCapital().getValue());
			questions.setOption2(main.getResults().getBindings().get(j).getCapital().getValue());
			questions.setOption3(main.getResults().getBindings().get(c).getCapital().getValue());
			questions.setOption4(main.getResults().getBindings().get(k).getCapital().getValue());
			questions.setCorrectAnswer(main.getResults().getBindings().get(c).getCapital().getValue());
			repo.save(questions);
		}
		System.out.println(questions.getQuestionStem());
		System.out.println(questions.getOption1());
		System.out.println(questions.getOption4());
		System.out.println(questions.getOption3());
		System.out.println(questions.getOption2());

		return questions;
	}

	public Questions presidents(Questions questions) throws JsonParseException, JsonMappingException, IOException {

//		Band name query , WORKING
//		String sparqlQuery = "PREFIX dbo: <http://dbpedia.org/ontology/>\n" + 
//				"PREFIX dbp: <http://dbpedia.org/resource/>\n" + 
//				"PREFIX foaf: <http://xmlns.com/foaf/0.1/>\n" + 
//				"\n" + 
//				"SELECT ?name ?bandname where {\n" + 
//				"  ?person foaf:name ?name .\n" + 
//				"  ?band dbo:bandMember ?person .\n" + 
//				"  ?band dbo:genre dbp:Punk_rock .\n" + 
//				"  ?band foaf:name ?bandname .\n" + 
//				"}";

		
		//		WIKI DATA.HOW PRESIDENT DIE
		String sparqlQuery= "PREFIX wikibase: <http://wikiba.se/ontology#>\n" + 
				"PREFIX wd: <http://www.wikidata.org/entity/>\n" + 
				"PREFIX wdt: <http://www.wikidata.org/prop/direct/>\n" + 
				"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" + 
				"\n" + 
				"SELECT ?president ?cause ?dob ?dod WHERE {\n" + 
				"   ?pid wdt:P39 wd:Q11696 .\n" + 
				"   ?pid wdt:P509 ?cid .\n" + 
				"   ?pid wdt:P569 ?dob .\n" + 
				"   ?pid wdt:P570 ?dod .\n" + 
				"\n" + 
				"   OPTIONAL {\n" + 
				"       ?pid rdfs:label ?president filter (lang(?president) = \"en\") .\n" + 
				"   }\n" + 
				"   OPTIONAL {\n" + 
				"       ?cid rdfs:label ?cause filter (lang(?cause) = \"en\") .\n" + 
				"   }\n" + 
				"}";
		Query query = QueryFactory.create(sparqlQuery);
		QueryExecution queryExecution = QueryExecutionFactory.sparqlService("https://query.wikidata.org/sparql", query);
		ResultSet result = queryExecution.execSelect();

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ResultSetFormatter.outputAsJSON(outputStream, result);
		String json = new String(outputStream.toByteArray()).replace("{\n" + 
				"  \"head\": {\n" + 
				"    \"vars\": [ \"president\" , \"cause\" , \"dob\" , \"dod\" ]\n" + 
				"  } ,", " ");
		System.out.println(json);
		// ObjectMapper objectMapper = new ObjectMapper();
		// Main main = objectMapper.readValue(json, Main.class);

		return questions;

	}

}