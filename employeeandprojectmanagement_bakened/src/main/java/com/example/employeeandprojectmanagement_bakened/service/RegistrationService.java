package com.example.employeeandprojectmanagement_bakened.service;

import com.example.employeeandprojectmanagement_bakened.exception.ResourceAlreadyExistException;
import com.example.employeeandprojectmanagement_bakened.model.Employee;
import com.example.employeeandprojectmanagement_bakened.model.User;
import com.example.employeeandprojectmanagement_bakened.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistrationService {

    private RegistrationRepository registrationRepository;

    public RegistrationService(RegistrationRepository registrationRepository) {
     this.registrationRepository=registrationRepository;
    }

    public User insertUser(User user) {

            return registrationRepository.save(user);


    }


    public User fetchUserByEmailId(String email){
        return registrationRepository.findByEmailId(email);
    }


    public User fetchUserByEmailIdAndPassword(String email, String password){
        return registrationRepository.findByEmailIdAndPassword(email,password);
    }
}
