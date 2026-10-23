package com.example.demo.controller;

import com.example.demo.model.Question;
import com.example.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

// REST Controller is a annotation that marks the class as a controller
// that is a component that handles HTTP requests
@RestController
// RequestMapping is a annotation that maps HTTP requests to handler methods
// it is used to map the HTTP requests to the methods in the controller
@RequestMapping("/api/v1/Questions")
public class QuestionRestController {

    @Autowired
    private QuestionService QuestionService;

    @GetMapping("/getAll")
    public Iterable<Question> getAllQuestions() {
        // call service to get all Questions and return them
        Iterable<Question> Questions =  QuestionService.getAllQuestions();
        System.out.println("Service getAllQuestions: " + Questions);
        return Questions;
    }

    @GetMapping("/byId")
    public Question getQuestionById(@RequestParam String id) {
        Question Question = QuestionService.getQuestionById(id);
        System.out.println("Service getQuestionById: " + Question);
        return Question;
    }

    @GetMapping("/count")
    public long countQuestions() {
        long count = QuestionService.countQuestions();
        System.out.println("Service countQuestions: " + count);
        return count;
    }

    @DeleteMapping("/byId")
    public void deleteById(@RequestParam String id) {
       QuestionService.deleteQuestionById(id);
    }

    @DeleteMapping("/all")
    public void deleteAllQuestions() {
        QuestionService.deleteAllQuestions();
    }
    @PostMapping("/saveAll")
    public void createQuestion(@RequestBody ArrayList<Question> questions) {
        QuestionService.saveAll(questions);
    }

}
