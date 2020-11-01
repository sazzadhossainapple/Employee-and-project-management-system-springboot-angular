package com.example.employeeandprojectmanagement_bakened.repository;

import com.example.employeeandprojectmanagement_bakened.model.SalaryGrade;
import com.example.employeeandprojectmanagement_bakened.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface SalaryGradeRepository extends JpaRepository<SalaryGrade, String> {

    public SalaryGrade findByGrade(String grade);
    @Transactional
    public SalaryGrade deleteByGrade(String grade);
}
