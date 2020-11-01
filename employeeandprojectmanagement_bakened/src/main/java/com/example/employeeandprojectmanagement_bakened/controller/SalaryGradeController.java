package com.example.employeeandprojectmanagement_bakened.controller;

import com.example.employeeandprojectmanagement_bakened.exception.ResourceAlreadyExistException;
import com.example.employeeandprojectmanagement_bakened.exception.ResourceDoseNotExistException;
import com.example.employeeandprojectmanagement_bakened.model.Employee;
import com.example.employeeandprojectmanagement_bakened.model.SalaryGrade;
import com.example.employeeandprojectmanagement_bakened.service.SalaryGradeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v3/salarygrade")
//@CrossOrigin(origins = "http://localhost:4200")
public class SalaryGradeController {

    private SalaryGradeService salaryGradeService;

    public SalaryGradeController(SalaryGradeService salaryGradeService) {
        this.salaryGradeService = salaryGradeService;
    }

    @GetMapping("")
    public ResponseEntity<List<SalaryGrade>> getSalary() {
        List<SalaryGrade> salaryGradeList= salaryGradeService.findAll();
        return ResponseEntity.ok(salaryGradeList);
    }



    @PostMapping("")
    public ResponseEntity<SalaryGrade> insertSalary(@RequestBody SalaryGrade salaryGrade) {
        try {
            SalaryGrade insertSalary = salaryGradeService.insertSalaryGrade(salaryGrade);
            return ResponseEntity.status(HttpStatus.CREATED).body(insertSalary);
        } catch (ResourceAlreadyExistException e) {
            return ResponseEntity.badRequest().body(null);
        }

    }

//    @DeleteMapping("/{grade}")
//    public void deleteSalary(@PathVariable String grade){
//       salaryGradeService.deleteSalaryGrade(grade);
//    }

    @DeleteMapping("/{grade}")
    public ResponseEntity<String> deleteSalary(@PathVariable String grade) {
        try {
            boolean deleted = salaryGradeService.deleteByGrade(grade);
            return  ResponseEntity.ok(grade);
        } catch (ResourceDoseNotExistException e) {
            return ResponseEntity.notFound().build();

        }

    }
}
