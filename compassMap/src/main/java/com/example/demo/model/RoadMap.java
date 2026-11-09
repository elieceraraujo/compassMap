package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Map;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoadMap {

    //fields
    @Id
    //@GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String description;
    @ElementCollection(fetch = FetchType.EAGER)
    private Map<String, String> stepsItemsSumary;
    private int steps;
    private boolean completed;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch =  FetchType.EAGER, mappedBy = "roadMaps")
    @EqualsAndHashCode.Exclude
    private List<CustomerProfile> customerProfiles;

    //methods
    public String toString(){
        return String.format(
                "RoadMap[id=%s, name='%s', description='%s']",
                id, name, description);
    }

}
