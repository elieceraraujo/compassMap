package com.example.demo.controller;

import com.example.demo.model.CustomerProfile;
import com.example.demo.service.CustomerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// REST Controller is a annotation that marks the class as a controller
// that is a component that handles HTTP requests
@RestController
// RequestMapping is a annotation that maps HTTP requests to handler methods
// it is used to map the HTTP requests to the methods in the controller
@RequestMapping("/api/v1/CustomerProfiles")
public class CustomerProfileRestController {

    @Autowired
    private CustomerProfileService CustomerProfileService;

    @GetMapping("/getAll")
    public Iterable<CustomerProfile> getAllCustomerProfiles() {
        // call service to get all CustomerProfiles and return them
        Iterable<CustomerProfile> CustomerProfiles =  CustomerProfileService.getAllCustomerProfiles();
        System.out.println("Service getAllCustomerProfiles: " + CustomerProfiles);
        return CustomerProfiles;
    }

    @GetMapping("/byId")
    public CustomerProfile getCustomerProfileById(@RequestParam String id) {
        CustomerProfile CustomerProfile = CustomerProfileService.getCustomerProfileById(id);
        System.out.println("Service getCustomerProfileById: " + CustomerProfile);
        return CustomerProfile;
    }

    @GetMapping("/count")
    public long countCustomerProfiles() {
        long count = CustomerProfileService.countCustomerProfiles();
        System.out.println("Service countCustomerProfiles: " + count);
        return count;
    }

    @DeleteMapping("/byId")
    public void deleteById(@RequestParam String id) {
       CustomerProfileService.deleteCustomerProfile(id);
    }

    @DeleteMapping("/all")
    public void deleteAllCustomerProfiles() {
        CustomerProfileService.deleteAllCustomerProfiles();
    }
}
