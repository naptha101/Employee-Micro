package com.example.employee2.entity;

import jakarta.persistence.*;
import jdk.jfr.Name;

@Entity
@Table(name = "employees" )
public class EmployeeEntity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "employee_id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "bloodgrp")
    private String bloodGroup;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
