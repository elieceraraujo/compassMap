package com.example.demo.controller;

import com.example.demo.model.RoadMap;
import com.example.demo.service.RoadMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// REST Controller is a annotation that marks the class as a controller
// that is a component that handles HTTP requests
@RestController
// RequestMapping is a annotation that maps HTTP requests to handler methods
// it is used to map the HTTP requests to the methods in the controller
@RequestMapping("/api/v1/RoadMaps")
public class RoadMapRestController {

    @Autowired
    private RoadMapService RoadMapService;


    @GetMapping("/getAll")
    public Iterable<RoadMap> getAllRoadMaps() {
        // call service to get all RoadMaps and return them
        Iterable<RoadMap> RoadMaps =  RoadMapService.getAllRoadMaps();
        System.out.println("Service getAllRoadMaps: " + RoadMaps);
        return RoadMaps;
    }

    @GetMapping("/byId")
    public RoadMap getRoadMapById(@RequestParam String id) {
        RoadMap RoadMap = RoadMapService.getRoadMapById(id);
        System.out.println("Service getRoadMapById: " + RoadMap);
        return RoadMap;
    }

    @GetMapping("/count")
    public long countRoadMaps() {
        long count = RoadMapService.countRoadMaps();
        System.out.println("Service countRoadMaps: " + count);
        return count;
    }

    @DeleteMapping("/byId")
    public void deleteById(@RequestParam String id) {
       RoadMapService.deleteRoadMapById(id);
    }

    @DeleteMapping("/all")
    public void deleteAllRoadMaps() {
        RoadMapService.deleteAllRoadMaps();
    }

    @PostMapping("/create")
    public RoadMap createRoadMap(@RequestBody RoadMap roadMap) {
        return RoadMapService.createRoadMap(roadMap);
    }

    @PutMapping("/update")
    public RoadMap updateRoadMap(@RequestParam String id, @RequestBody RoadMap roadMap) {
        return RoadMapService.updateRoadMap(id,roadMap);

    }
}
