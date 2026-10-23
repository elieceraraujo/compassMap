package com.example.demo.service;

import com.example.demo.model.CustomerProfile;
import com.example.demo.repository.CustomerProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CustomerProfileService {

    // we are using here DEPENDENCE INJECTION
    @Autowired
    private CustomerProfileRepository CustomerProfileRepository;

    public Iterable<CustomerProfile> getAllCustomerProfiles() {
        return CustomerProfileRepository.findAll();
    }

    public CustomerProfile createCustomerProfile (CustomerProfile CustomerProfile){
        // SET ID CustomerProfile to UUID
        //CustomerProfile.setId(UUID.randomUUID().toString());

        // call repository to use SAVE operation to save data to h2 db
        CustomerProfile createdCustomerProfile = CustomerProfileRepository.save(CustomerProfile);
        System.out.println("Service created CustomerProfile: " +  createdCustomerProfile);
        return createdCustomerProfile;
    }

    public void deleteCustomerProfile (String id){
      CustomerProfileRepository.deleteById(id);

    }

    public CustomerProfile getCustomerProfileById(String id){

        Optional<CustomerProfile> foundCustomerProfile = CustomerProfileRepository.findById(id);

        return foundCustomerProfile.get();
    }

    public void saveAll(ArrayList<CustomerProfile> CustomerProfiles) {
        CustomerProfileRepository.saveAll(CustomerProfiles);
    }

    public void deleteAllCustomerProfiles() {
        CustomerProfileRepository.deleteAll();
    }

    public long countCustomerProfiles() {
        return CustomerProfileRepository.count();
    }

}
