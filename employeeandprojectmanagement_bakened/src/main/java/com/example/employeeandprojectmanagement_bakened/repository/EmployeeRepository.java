package com.example.employeeandprojectmanagement_bakened.repository;

import com.example.employeeandprojectmanagement_bakened.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
