package com.example.employeeandprojectmanagement_bakened.service;

import com.example.employeeandprojectmanagement_bakened.exception.ResourceAlreadyExistException;
import com.example.employeeandprojectmanagement_bakened.exception.ResourceDoseNotExistException;
import com.example.employeeandprojectmanagement_bakened.model.Employee;
import com.example.employeeandprojectmanagement_bakened.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public Employee findById(long id) throws ResourceDoseNotExistException {

        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            return optionalEmployee.get();
        } else {
            throw new ResourceDoseNotExistException(id + "");
        }
    }


    //findAll method
    public List<Employee> findAll() {
        List<Employee> employeeList = new ArrayList<>();
        employeeRepository.findAll().forEach(employeeList::add);
        return employeeList;
    }


    //insert method
    public Employee insertEmployee(Employee employee) throws ResourceAlreadyExistException {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employee.getEmployeeId());
        if (optionalEmployee.isPresent()) {
            throw new ResourceAlreadyExistException(employee.getEmployeeId() + "");
        } else {
            return employeeRepository.save(employee);
        }

    }



    //update method

    public Employee updateEmployee(long id,Employee employee) throws ResourceDoseNotExistException {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {

            employee.setEmployeeId(id);
            return employeeRepository.save(employee);

        } else {
            throw new ResourceDoseNotExistException(id + "");
        }

    }


    //deleteById method
    public boolean deleteById(long id) throws ResourceDoseNotExistException {

        Optional<Employee> employeeOptional = employeeRepository.findById(id);
       employeeOptional.ifPresent(event -> employeeRepository.deleteById(id));
        employeeOptional.orElseThrow(() -> new ResourceDoseNotExistException(id + ""));
        return true;

    }
}
