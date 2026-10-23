package com.example.demo.service;

import com.example.demo.model.Question;
import com.example.demo.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class QuestionService {

    // we are using here DEPENDENCE INJECTION
    @Autowired
    private QuestionRepository QuestionRepository;

    public Iterable<Question> getAllQuestions() {
        return QuestionRepository.findAll();
    }

    public Question createQuestion (Question Question){
        // SET ID Question to UUID
        //Question.setId(UUID.randomUUID().toString());

        // call repository to use SAVE operation to save data to h2 db
        Question createdQuestion = QuestionRepository.save(Question);
        System.out.println("Service created Question: " +  createdQuestion);
        return createdQuestion;
    }

    public void deleteQuestionById (String id){
      QuestionRepository.deleteById(id);

    }

    public Question getQuestionById(String id){

        Optional<Question> foundQuestion = QuestionRepository.findById(id);

        return foundQuestion.get();
    }

    public void saveAll(ArrayList<Question> Questions) {
        QuestionRepository.saveAll(Questions);
    }

    public void deleteAllQuestions() {
        QuestionRepository.deleteAll();
    }

    public long countQuestions() {
        return QuestionRepository.count();
    }

    public Question updateQuestion (String id, Question QuestionChanges){

        Question QuestionToUpdate = getQuestionById(id);
        QuestionToUpdate.setText(QuestionChanges.getText());
        QuestionToUpdate.setDimension(QuestionChanges.getDimension());
        QuestionToUpdate.setArrangement(QuestionChanges.getArrangement());
        QuestionToUpdate.setWeight(QuestionChanges.getWeight());

        return QuestionRepository.save(QuestionToUpdate);
    }

}
