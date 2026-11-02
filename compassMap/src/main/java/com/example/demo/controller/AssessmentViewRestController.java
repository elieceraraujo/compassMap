package com.example.demo.controller;

import com.example.demo.model.AssessmentView;
import com.example.demo.service.AssessmentViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// REST Controller is a annotation that marks the class as a controller
// that is a component that handles HTTP requests
@RestController
// RequestMapping is a annotation that maps HTTP requests to handler methods
// it is used to map the HTTP requests to the methods in the controller
@RequestMapping("/api/v1/AssessmentViews")
public class AssessmentViewRestController {

    @Autowired
    private AssessmentViewService AssessmentViewService;

    @GetMapping("/getAll")
    public Iterable<AssessmentView> getAllAssessmentViews() {
        // call service to get all AssessmentViews and return them
        Iterable<AssessmentView> AssessmentViews =  AssessmentViewService.getAllAssessmentViews();
        System.out.println("Service getAllAssessmentViews: " + AssessmentViews);
        return AssessmentViews;
    }

    @GetMapping("/byId")
    public AssessmentView getAssessmentViewById(@RequestParam String id) {
        AssessmentView AssessmentView = AssessmentViewService.getAssessmentViewById(id);
        System.out.println("Service getAssessmentViewById: " + AssessmentView);
        return AssessmentView;
    }

    @GetMapping("/count")
    public long countAssessmentViews() {
        long count = AssessmentViewService.countAssessmentViews();
        System.out.println("Service countAssessmentViews: " + count);
        return count;
    }

    @DeleteMapping("/byId")
    public void deleteById(@RequestParam String id) {
       AssessmentViewService.deleteAssessmentViewById(id);
    }

    @DeleteMapping("/all")
    public void deleteAllAssessmentViews() {
        AssessmentViewService.deleteAllAssessmentViews();
    }
}
