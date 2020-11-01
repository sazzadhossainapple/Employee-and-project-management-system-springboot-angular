package com.example.employeeandprojectmanagement_bakened.service;

import com.example.employeeandprojectmanagement_bakened.exception.ResourceAlreadyExistException;
import com.example.employeeandprojectmanagement_bakened.exception.ResourceDoseNotExistException;
import com.example.employeeandprojectmanagement_bakened.model.Department;
import com.example.employeeandprojectmanagement_bakened.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }



    // findById method
    public Department findById(long id) throws ResourceDoseNotExistException {

        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        if (optionalDepartment.isPresent()) {
            return optionalDepartment.get();
        } else {
            throw new ResourceDoseNotExistException(id + "");
        }
    }

    //findAll method
    public List<Department> findAll() {
        List<Department> departmentList = new ArrayList<>();
        departmentRepository.findAll().forEach(departmentList::add);
        return departmentList;
    }

    //insert method
    public Department insertDepartment(Department department) throws ResourceAlreadyExistException {
        Optional<Department> optionalDepartment = departmentRepository.findById(department.getDepartmentId());
        if (optionalDepartment.isPresent()) {
            throw new ResourceAlreadyExistException(department.getDepartmentId() + "");
        } else {
            return departmentRepository.save(department);
        }

    }



    //update method

    public Department updateDepartment(long id,Department department) throws ResourceDoseNotExistException {
        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        if (optionalDepartment.isPresent()) {

            department.setDepartmentId(id);
            return departmentRepository.save(department);

        } else {
            throw new ResourceDoseNotExistException(id + "");
        }

    }

    //deleteById method
    public boolean deleteById(long id) throws ResourceDoseNotExistException {

        Optional<Department> departmentOptional = departmentRepository.findById(id);
      departmentOptional.ifPresent(event -> departmentRepository.deleteById(id));
        departmentOptional.orElseThrow(() -> new ResourceDoseNotExistException(id + ""));
        return true;

    }
}
