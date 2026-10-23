package com.example.demo.controller;

import com.example.demo.model.QuestionAndAnswer;
import com.example.demo.service.QuestionAndAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// REST Controller is a annotation that marks the class as a controller
// that is a component that handles HTTP requests
@RestController
// RequestMapping is a annotation that maps HTTP requests to handler methods
// it is used to map the HTTP requests to the methods in the controller
@RequestMapping("/api/v1/QuestionAndAnswers")
public class QuestionAndAnswerRestController {

    @Autowired
    private QuestionAndAnswerService QuestionAndAnswerService;

    @GetMapping("/getAll")
    public Iterable<QuestionAndAnswer> getAllQuestionAndAnswers() {
        // call service to get all QuestionAndAnswers and return them
        Iterable<QuestionAndAnswer> QuestionAndAnswers =  QuestionAndAnswerService.getAllQuestionAndAnswers();
        System.out.println("Service getAllQuestionAndAnswers: " + QuestionAndAnswers);
        return QuestionAndAnswers;
    }

    @GetMapping("/byId")
    public QuestionAndAnswer getQuestionAndAnswerById(@RequestParam String id) {
        QuestionAndAnswer QuestionAndAnswer = QuestionAndAnswerService.getQuestionAndAnswerById(id);
        System.out.println("Service getQuestionAndAnswerById: " + QuestionAndAnswer);
        return QuestionAndAnswer;
    }

    @GetMapping("/count")
    public long countQuestionAndAnswers() {
        long count = QuestionAndAnswerService.countQuestionAndAnswers();
        System.out.println("Service countQuestionAndAnswers: " + count);
        return count;
    }

    @DeleteMapping("/byId")
    public void deleteById(@RequestParam String id) {
       QuestionAndAnswerService.deleteQuestionAndAnswerById(id);
    }

    @DeleteMapping("/all")
    public void deleteAllQuestionAndAnswers() {
        QuestionAndAnswerService.deleteAllQuestionAndAnswers();
    }
}
