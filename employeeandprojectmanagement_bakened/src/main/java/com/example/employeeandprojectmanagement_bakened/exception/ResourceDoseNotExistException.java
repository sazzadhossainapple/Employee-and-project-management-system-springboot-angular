package com.example.employeeandprojectmanagement_bakened.exception;

public class ResourceDoseNotExistException extends Exception {
    public ResourceDoseNotExistException(String resource) {
        super(resource + "dose not exists!");
    }
}
