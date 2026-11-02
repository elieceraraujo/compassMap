package com.example.demo.service;

import com.example.demo.model.AssessmentView;
import com.example.demo.repository.AssessmentViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class AssessmentViewService {

    // we are using here DEPENDENCE INJECTION
    @Autowired
    private AssessmentViewRepository AssessmentViewRepository;

    public Iterable<AssessmentView> getAllAssessmentViews() {
        return AssessmentViewRepository.findAll();
    }

    public AssessmentView createAssessmentView (AssessmentView AssessmentView){
        // SET ID AssessmentView to UUID
        //AssessmentView.setId(UUID.randomUUID().toString());

        // call repository to use SAVE operation to save data to h2 db
        AssessmentView createdAssessmentView = AssessmentViewRepository.save(AssessmentView);
        System.out.println("Service created AssessmentView: " +  createdAssessmentView);
        return createdAssessmentView;
    }

    public void deleteAssessmentViewById (String id){
      AssessmentViewRepository.deleteById(id);

    }

    public AssessmentView getAssessmentViewById(String id){

        Optional<AssessmentView> foundAssessmentView = AssessmentViewRepository.findById(id);

        return foundAssessmentView.get();
    }

    public void saveAll(ArrayList<AssessmentView> AssessmentViews) {
        AssessmentViewRepository.saveAll(AssessmentViews);
    }

    public void deleteAllAssessmentViews() {
        AssessmentViewRepository.deleteAll();
    }

    public long countAssessmentViews() {
        return AssessmentViewRepository.count();
    }

    public AssessmentView updateAssessmentView (String id, AssessmentView AssessmentViewChanges){

        AssessmentView AssessmentViewToUpdate = getAssessmentViewById(id);
        AssessmentViewToUpdate.setQuestionsAndAnswers(AssessmentViewChanges.getQuestionsAndAnswers());
        AssessmentViewToUpdate.setCustomer(AssessmentViewChanges.getCustomer());
        AssessmentViewToUpdate.setProfile(AssessmentViewChanges.getProfile());
        AssessmentViewToUpdate.setQtyQuestions(AssessmentViewChanges.getQtyQuestions());
        AssessmentViewToUpdate.setTimestamp(AssessmentViewChanges.getTimestamp());

        return AssessmentViewRepository.save(AssessmentViewToUpdate);
    }

}
