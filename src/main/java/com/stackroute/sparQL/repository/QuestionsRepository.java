package com.stackroute.sparQL.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.sparQL.model.Questions;

@Repository
public interface QuestionsRepository extends MongoRepository<Questions, Integer>{

}
