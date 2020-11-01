package com.example.employeeandprojectmanagement_bakened.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@IdClass(Project.class)implements Serializable
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long projectNo;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "projectNo", referencedColumnName = "employeeId")
//    private Employee employees;


}
