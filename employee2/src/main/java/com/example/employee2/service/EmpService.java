package com.example.employee2.service;

import com.example.employee2.entity.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.employee2.repo.EmployeeRepo;

@Service
public class EmpService {
    @Autowired
    EmployeeRepo Repo;

    public EmployeeEntity GetData(int id){

       EmployeeEntity e= Repo.findById(id).get();

       return e;

    }


}
