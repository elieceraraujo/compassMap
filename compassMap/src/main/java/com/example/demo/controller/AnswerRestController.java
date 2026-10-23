package com.example.demo.controller;

import com.example.demo.model.Answer;
import com.example.demo.model.Question;
import com.example.demo.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

// REST Controller is a annotation that marks the class as a controller
// that is a component that handles HTTP requests
@RestController
// RequestMapping is a annotation that maps HTTP requests to handler methods
// it is used to map the HTTP requests to the methods in the controller
@RequestMapping("/api/v1/Answers")
public class AnswerRestController {

    @Autowired
    private AnswerService AnswerService;

    @GetMapping("/getAll")
    public Iterable<Answer> getAllAnswers() {
        // call service to get all Answers and return them
        Iterable<Answer> answers =  AnswerService.getAllAnswers();
        System.out.println("Service getAllAnswers: " + answers);
        return answers;
    }

    @GetMapping("/byId")
    public Answer getAnswerById(@RequestParam String id) {
        Answer answer = AnswerService.getAnswerById(id);
        System.out.println("Service getAnswerById: " + answer);
        return answer;
    }

    @GetMapping("/count")
    public long countAnswers() {
        long count = AnswerService.countAnswers();
        System.out.println("Service countAnswers: " + count);
        return count;
    }

    @DeleteMapping("/byId")
    public void deleteById(@RequestParam String id) {
       AnswerService.deleteAnswerById(id);
    }

    @DeleteMapping("/all")
    public void deleteAllAnswers() {
        AnswerService.deleteAllAnswers();
    }

    @PostMapping("/saveAll")
    public void createQuestion(@RequestBody ArrayList<Answer> answers) {
        AnswerService.saveAll(answers);
    }
}
