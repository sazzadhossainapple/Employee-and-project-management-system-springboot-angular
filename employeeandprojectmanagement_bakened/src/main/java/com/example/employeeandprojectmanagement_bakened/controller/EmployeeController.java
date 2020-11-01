package com.example.employeeandprojectmanagement_bakened.controller;

import com.example.employeeandprojectmanagement_bakened.exception.ResourceAlreadyExistException;
import com.example.employeeandprojectmanagement_bakened.exception.ResourceDoseNotExistException;
import com.example.employeeandprojectmanagement_bakened.model.Employee;
import com.example.employeeandprojectmanagement_bakened.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v3/employee")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

    private EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }



    @GetMapping("/{id}")

    public ResponseEntity<Employee> getEmployee(@PathVariable long id) {

        try {
            Employee employee = employeeService.findById(id);
            return ResponseEntity.ok(employee);
        } catch (ResourceDoseNotExistException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Employee>> getEmployee() {
        List<Employee> employeeList= employeeService.findAll();
        return ResponseEntity.ok(employeeList);
    }


    @PostMapping("")
    public ResponseEntity<Employee> insertEmployee(@RequestBody Employee employee) {
        try {
            Employee insertEmployee = employeeService.insertEmployee(employee);
            return ResponseEntity.status(HttpStatus.CREATED).body(insertEmployee);
        } catch (ResourceAlreadyExistException e) {
            return ResponseEntity.badRequest().body(null);
        }

    }


    @PutMapping("/{id}")
    public Employee update(@PathVariable long id, @RequestBody Employee employee) throws ResourceDoseNotExistException {
        return employeeService.updateEmployee(id,employee);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteProductById(@PathVariable long id) {
        try {
            boolean deleted = employeeService.deleteById(id);
            return ResponseEntity.ok(id);
        } catch (ResourceDoseNotExistException e) {
            return ResponseEntity.notFound().build();

        }

    }
}
