package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoadMap {

    //fields
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String description;
    private int steps;
    private boolean completed;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch =  FetchType.EAGER, mappedBy = "roadMaps")
    private List<CustomerProfile> customerProfiles;

    //methods
    public String toString(){
        return String.format(
                "RoadMap[id=%s, firstName='%s', description='%s']",
                id, name, description);
    }

}
