package com.example.employeeandprojectmanagement_bakened.service;

import com.example.employeeandprojectmanagement_bakened.exception.ResourceAlreadyExistException;
import com.example.employeeandprojectmanagement_bakened.exception.ResourceDoseNotExistException;
import com.example.employeeandprojectmanagement_bakened.model.Employee;
import com.example.employeeandprojectmanagement_bakened.model.Project;
import com.example.employeeandprojectmanagement_bakened.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    private ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;


    }

    public Project findById(long id) throws ResourceDoseNotExistException {

        Optional<Project> optionalProject = projectRepository.findById(id);
        if (optionalProject.isPresent()) {
            return optionalProject.get();
        } else {
            throw new ResourceDoseNotExistException(id + "");
        }
    }

    //findAll method
    public List<Project> findAll() {
        List<Project> projectList = new ArrayList<>();
        projectRepository.findAll().forEach(projectList::add);
        return projectList;
    }

    //insert method
    public Project insertProject(Project project) throws ResourceAlreadyExistException {
        Optional<Project> optionalProject= projectRepository.findById(project.getProjectNo());
        if (optionalProject.isPresent()) {
            throw new ResourceAlreadyExistException(project.getProjectNo() + "");
        } else {
            return projectRepository.save(project);
        }

    }


    //update method

    public Project updateProject(long id,Project project) throws ResourceDoseNotExistException {
        Optional<Project> optionalProject =projectRepository.findById(id);
        if (optionalProject.isPresent()) {

            project.setProjectNo(id);
            return projectRepository.save(project);

        } else {
            throw new ResourceDoseNotExistException(id + "");
        }

    }


    //deleteById method
    public boolean deleteById(long id) throws ResourceDoseNotExistException {

        Optional<Project> optionalProject = projectRepository.findById(id);
        optionalProject.ifPresent(event -> projectRepository.deleteById(id));
        optionalProject.orElseThrow(() -> new ResourceDoseNotExistException(id + ""));
        return true;

    }

}
