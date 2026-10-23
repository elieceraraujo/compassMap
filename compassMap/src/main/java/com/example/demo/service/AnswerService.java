package com.example.demo.service;

import com.example.demo.model.Answer;
import com.example.demo.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class AnswerService {

    // we are using here DEPENDENCE INJECTION
    @Autowired
    private AnswerRepository AnswerRepository;

    public Iterable<Answer> getAllAnswers() {
        return AnswerRepository.findAll();
    }

    public Answer createAnswer (Answer answer){
        // SET ID Answer to UUID
        //Answer.setId(UUID.randomUUID().toString());

        // call repository to use SAVE operation to save data to h2 db
        Answer createdAnswer = AnswerRepository.save(answer);
        System.out.println("Service created Answer: " +  createdAnswer);
        return createdAnswer;
    }

    public void deleteAnswerById (String id){
      AnswerRepository.deleteById(id);

    }

    public Answer getAnswerById(String id){

        Optional<Answer> foundAnswer = AnswerRepository.findById(id);

        return foundAnswer.get();
    }

    public void saveAll(ArrayList<Answer> Answers) {
        AnswerRepository.saveAll(Answers);
    }

    public void deleteAllAnswers() {
        AnswerRepository.deleteAll();
    }

    public long countAnswers() {
        return AnswerRepository.count();
    }

    public Answer updateAnswer (String id, Answer AnswerChanges){

        Answer AnswerToUpdate = getAnswerById(id);
        AnswerToUpdate.setTexto(AnswerChanges.getTexto());
        AnswerToUpdate.setValue(AnswerChanges.getValue());

        return AnswerRepository.save(AnswerToUpdate);
    }

}
