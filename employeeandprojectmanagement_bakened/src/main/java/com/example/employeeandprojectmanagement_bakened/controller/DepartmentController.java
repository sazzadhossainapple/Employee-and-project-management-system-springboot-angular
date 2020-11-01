package com.example.employeeandprojectmanagement_bakened.controller;

import com.example.employeeandprojectmanagement_bakened.exception.ResourceAlreadyExistException;
import com.example.employeeandprojectmanagement_bakened.exception.ResourceDoseNotExistException;
import com.example.employeeandprojectmanagement_bakened.model.Department;
import com.example.employeeandprojectmanagement_bakened.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v3/department")
@CrossOrigin(origins = "http://localhost:4200")
public class DepartmentController {


    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartment(@PathVariable long id) {

        try {
            Department department = departmentService.findById(id);
            return ResponseEntity.ok(department);
        } catch (ResourceDoseNotExistException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Department>> getDepartment() {
        List<Department> departmentList = departmentService.findAll();
        return ResponseEntity.ok(departmentList);
    }



    @PostMapping("")
    public ResponseEntity<Department> insertDepartment(@RequestBody Department department) {
        try {
           Department insertDepartment = departmentService.insertDepartment(department);
            return ResponseEntity.status(HttpStatus.CREATED).body(insertDepartment);
        } catch (ResourceAlreadyExistException e) {
            return ResponseEntity.badRequest().body(null);
        }

    }

    @PutMapping("/{id}")
    public Department update(@PathVariable long id,@RequestBody Department department) throws ResourceDoseNotExistException {
        return departmentService.updateDepartment(id,department);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteDepartmentById(@PathVariable long id) {
        try {
            boolean deleted = departmentService.deleteById(id);
            return ResponseEntity.ok(id);
        } catch (ResourceDoseNotExistException e) {
            return ResponseEntity.notFound().build();

        }

    }

}
