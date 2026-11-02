package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.javafaker.PhoneNumber;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;

import java.time.Instant;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssessmentView {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="CUSTOMER_FK", referencedColumnName = "ID")
    private Customer customer;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "ASSESMENTVIEW_QANDA_JOIN_TABLE",
            joinColumns = @JoinColumn(name = "ASW_FK", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "QANDA_FK", referencedColumnName = "ID"))
    private List<QuestionAndAnswer> questionsAndAnswers;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch =  FetchType.EAGER)
    @JoinColumn(name ="CPROFILE_FK", referencedColumnName = "ID")
    private CustomerProfile profile;

    private Instant timestamp;
    private int qtyQuestions;


}
