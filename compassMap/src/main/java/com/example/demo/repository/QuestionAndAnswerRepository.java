package com.example.demo.repository;

import com.example.demo.model.QuestionAndAnswer;
import org.springframework.data.repository.CrudRepository;


public interface QuestionAndAnswerRepository extends CrudRepository<QuestionAndAnswer, String> {}