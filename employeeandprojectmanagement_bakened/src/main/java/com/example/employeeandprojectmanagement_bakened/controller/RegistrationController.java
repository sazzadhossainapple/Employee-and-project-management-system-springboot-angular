package com.example.employeeandprojectmanagement_bakened.controller;

import com.example.employeeandprojectmanagement_bakened.exception.ResourceAlreadyExistException;
import com.example.employeeandprojectmanagement_bakened.exception.ResourceDoseNotExistException;
import com.example.employeeandprojectmanagement_bakened.model.User;
import com.example.employeeandprojectmanagement_bakened.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v3/registration")
@CrossOrigin(origins = "http://localhost:4200")
public class RegistrationController {


    private RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("")

    public User registrationUser(@RequestBody User user) throws ResourceAlreadyExistException {
        String tempEmailId = user.getEmailId();
        if(tempEmailId != null && !"".equals(tempEmailId)){
          User userobj = registrationService.fetchUserByEmailId(tempEmailId);

          if(userobj !=null){
              throw new  ResourceAlreadyExistException("user with " +tempEmailId+"is already exist");

          }
        }
        User userobj=null;

        userobj = registrationService.insertUser(user);
        return userobj;

    }

    @PostMapping("login")
    public  User loginUser(@RequestBody User user) throws ResourceDoseNotExistException {

        String tempEmailId= user.getEmailId();
        String tempPass= user.getPassword();
        User userobj=null;
        if(tempEmailId !=null && tempPass !=null){
            userobj= registrationService.fetchUserByEmailIdAndPassword(tempEmailId,tempPass);

        }
        if(userobj==null)
        {
            throw new ResourceDoseNotExistException("Bad credentials");
        }
        return userobj;
    }
}
