package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerProfile {

    @Id
    private String id;
    @Enumerated(EnumType.STRING)
    private  CodeProfile codeProfile;
    private String name;
    private String description;
    private String goal;

    @JsonIgnore
    @Builder.Default
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "profile")
    private List<AssessmentView> assessmentViews =  new ArrayList<>();

    @JsonIgnore
    @Builder.Default
    @ManyToMany(cascade = CascadeType.ALL, fetch =  FetchType.EAGER)
    @JoinTable(name = "CPROFILE_ROADMAP_JOIN_TABLE"
            , joinColumns = @JoinColumn(name = "CPROFILE_FK")
            , inverseJoinColumns = @JoinColumn(name ="ROADMAP_FK"))
    private List<RoadMap> roadMaps = new ArrayList<>();
    // answers of the customer per dimension
    //private HashMap<Dimension, Boolean> answers;
    // recommended roadmap
    //private RoadMap recommendedRoadmap;


    public String toString() {
        return String.format(
                "Profile[id=%s, name='%s']",
                id, name);
    }
}
