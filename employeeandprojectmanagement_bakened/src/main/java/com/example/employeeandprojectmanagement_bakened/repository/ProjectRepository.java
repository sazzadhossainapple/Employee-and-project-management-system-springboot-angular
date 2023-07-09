package com.example.employeeandprojectmanagement_bakened.repository;

import com.example.employeeandprojectmanagement_bakened.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository  extends JpaRepository<Project,Long> {
}
