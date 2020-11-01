package com.example.employeeandprojectmanagement_bakened.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SalaryGrade {
    @Id
    private String grade;
    private BigDecimal lowSalary;
    private BigDecimal highSalary;
}
