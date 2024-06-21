package com.example.employee2.Controller;

import com.example.employee2.entity.EmployeeEntity;
import com.example.employee2.models.AddressResponse;
import com.example.employee2.models.EmployeeModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.employee2.service.EmpService;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {

    @Autowired
    EmpService Repo;
   @Autowired
    ModelMapper ma;
   @Autowired
   private RestTemplate re;


   @Value("${addressservce.base.url}")
   private String AddressUrl;

    @GetMapping("/getemp/{id}")
    public ResponseEntity<EmployeeModel> getEmp(@PathVariable("id") int id){
     EmployeeEntity e=Repo.GetData(id);
     System.out.println(e);
    EmployeeModel m=  ma.map(e,EmployeeModel.class);

        AddressResponse res=re.getForObject(AddressUrl+"/getadd/{id}",AddressResponse.class,id);
        m.setAddress(res);
        //BeanUtils.copyProperties(e,m);
     return ResponseEntity.status(HttpStatus.OK).body(m);
    }


}
