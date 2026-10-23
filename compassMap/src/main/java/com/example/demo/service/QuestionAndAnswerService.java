package com.example.demo.service;

import com.example.demo.model.QuestionAndAnswer;
import com.example.demo.repository.QuestionAndAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class QuestionAndAnswerService {

    // we are using here DEPENDENCE INJECTION
    @Autowired
    private QuestionAndAnswerRepository QuestionAndAnswerRepository;

    public Iterable<QuestionAndAnswer> getAllQuestionAndAnswers() {
        return QuestionAndAnswerRepository.findAll();
    }

    public QuestionAndAnswer createQuestionAndAnswer (QuestionAndAnswer QuestionAndAnswer){
        // SET ID QuestionAndAnswer to UUID
        //QuestionAndAnswer.setId(UUID.randomUUID().toString());

        // call repository to use SAVE operation to save data to h2 db
        QuestionAndAnswer createdQuestionAndAnswer = QuestionAndAnswerRepository.save(QuestionAndAnswer);
        System.out.println("Service created QuestionAndAnswer: " +  createdQuestionAndAnswer);
        return createdQuestionAndAnswer;
    }

    public void deleteQuestionAndAnswerById (String id){
      QuestionAndAnswerRepository.deleteById(id);

    }

    public QuestionAndAnswer getQuestionAndAnswerById(String id){

        Optional<QuestionAndAnswer> foundQuestionAndAnswer = QuestionAndAnswerRepository.findById(id);

        return foundQuestionAndAnswer.get();
    }

    public void saveAll(ArrayList<QuestionAndAnswer> QuestionAndAnswers) {
        QuestionAndAnswerRepository.saveAll(QuestionAndAnswers);
    }

    public void deleteAllQuestionAndAnswers() {
        QuestionAndAnswerRepository.deleteAll();
    }

    public long countQuestionAndAnswers() {
        return QuestionAndAnswerRepository.count();
    }

    public QuestionAndAnswer updateQuestionAndAnswer (String id, QuestionAndAnswer QuestionAndAnswerChanges){

        QuestionAndAnswer QuestionAndAnswerToUpdate = getQuestionAndAnswerById(id);
        QuestionAndAnswerToUpdate.setQuestion(QuestionAndAnswerChanges.getQuestion());
        QuestionAndAnswerToUpdate.setAnswers(QuestionAndAnswerChanges.getAnswers());
        QuestionAndAnswerToUpdate.setScoreContribution(QuestionAndAnswerChanges.getScoreContribution());

        return QuestionAndAnswerRepository.save(QuestionAndAnswerToUpdate);
    }

}
