package com.example.University.Event.Management.model;


import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Table
@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer studentId;
   // @Pattern(regexp="[A-Z][a-z]*$")
    private String firstName;
    private String lastName;
@Min(value=18)
@Max(value=25)
    private int age;
@Enumerated(EnumType.STRING)
    private Department department;

}
