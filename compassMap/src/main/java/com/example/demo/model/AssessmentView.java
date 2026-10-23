package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssessmentView {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;
    private Instant timestamp;
    private int qtyQuestions;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<QuestionAndAnswer> questionsAndAnswers;
    @ManyToOne(cascade = CascadeType.ALL)
    private CustomerProfile profile;


}
