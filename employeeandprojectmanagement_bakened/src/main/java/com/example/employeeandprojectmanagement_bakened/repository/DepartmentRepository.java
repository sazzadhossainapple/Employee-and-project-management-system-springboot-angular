package com.example.employeeandprojectmanagement_bakened.repository;

import com.example.employeeandprojectmanagement_bakened.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
