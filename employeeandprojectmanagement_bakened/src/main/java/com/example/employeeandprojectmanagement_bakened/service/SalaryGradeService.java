package com.example.employeeandprojectmanagement_bakened.service;

import com.example.employeeandprojectmanagement_bakened.exception.ResourceAlreadyExistException;
import com.example.employeeandprojectmanagement_bakened.exception.ResourceDoseNotExistException;
import com.example.employeeandprojectmanagement_bakened.model.Employee;
import com.example.employeeandprojectmanagement_bakened.model.SalaryGrade;
import com.example.employeeandprojectmanagement_bakened.repository.SalaryGradeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SalaryGradeService {

    private SalaryGradeRepository salaryGradeRepository;

    public SalaryGradeService(SalaryGradeRepository salaryGradeRepository) {
        this.salaryGradeRepository = salaryGradeRepository;
    }


    //findAll method
    public List<SalaryGrade> findAll() {
        List<SalaryGrade> salaryGradeList = new ArrayList<>();
        salaryGradeRepository.findAll().forEach(salaryGradeList::add);
        return salaryGradeList;
    }


    //insert method
    public SalaryGrade insertSalaryGrade(SalaryGrade salaryGrade) throws ResourceAlreadyExistException {
        Optional<SalaryGrade> optionalSalaryGrade = salaryGradeRepository.findById(salaryGrade.getGrade());
        if (optionalSalaryGrade.isPresent()) {
            throw new ResourceAlreadyExistException(salaryGrade.getGrade() + "");
        } else {
            return salaryGradeRepository.save(salaryGrade);
        }

    }

    //deleteById method
//
//    public void deleteSalaryGrade(String grade){
//        salaryGradeRepository.deleteByGrade(grade);
//    }
    public boolean deleteByGrade(String grade) throws ResourceDoseNotExistException {

        Optional<SalaryGrade> optionalSalaryGrade= Optional.ofNullable(salaryGradeRepository.findByGrade(grade));
        optionalSalaryGrade.ifPresent(event -> salaryGradeRepository.deleteByGrade(grade));
        optionalSalaryGrade.orElseThrow(() -> new ResourceDoseNotExistException(grade + ""));
        return true;

    }
}
