package com.example.employeeandprojectmanagement_bakened.controller;

import com.example.employeeandprojectmanagement_bakened.exception.ResourceAlreadyExistException;
import com.example.employeeandprojectmanagement_bakened.exception.ResourceDoseNotExistException;
import com.example.employeeandprojectmanagement_bakened.model.Project;
import com.example.employeeandprojectmanagement_bakened.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v3/project")
@CrossOrigin(origins = "http://localhost:4200")
public class ProjectController {

    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {

        this.projectService = projectService;
    }


    @GetMapping("/{id}")

    public ResponseEntity<Project> getProject(@PathVariable long id) {

        try {
            Project project= projectService.findById(id);
            return ResponseEntity.ok(project);
        } catch (ResourceDoseNotExistException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Project>> getProject() {
        List<Project> projectList= projectService.findAll();
        return ResponseEntity.ok(projectList);
    }

    @PostMapping("")
    public ResponseEntity<Project> insertProjectss(@RequestBody Project project) {
        try {
            Project insertProjects= projectService.insertProject(project);
            return ResponseEntity.status(HttpStatus.CREATED).body(insertProjects);
        } catch (ResourceAlreadyExistException e) {
            return ResponseEntity.badRequest().body(null);
        }

    }

    @PutMapping("/{id}")
    public Project update(@PathVariable long id, @RequestBody Project project) throws ResourceDoseNotExistException {
        return projectService.updateProject(id,project);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteProductById(@PathVariable long id) {
        try {
            boolean deleted = projectService.deleteById(id);
            return ResponseEntity.ok(id);
        } catch (ResourceDoseNotExistException e) {
            return ResponseEntity.notFound().build();

        }

    }
}
