package com.hamitmizrak.ui.rest.impl;

import com.hamitmizrak.business.dto.BlogRegisterDto;
import com.hamitmizrak.business.dto.EmployeeDto;
import com.hamitmizrak.business.service.IEmployeeServices;
import com.hamitmizrak.exception.ApiResult;
import com.hamitmizrak.ui.rest.IEmployeeRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1")

//dünyaya açılacak kapımız (React;) bu kısımda ilişkilendireceğiz.
public class EmployeeRestImpl  implements IEmployeeRest {


    IEmployeeServices services;
    @Autowired
    public EmployeeRestImpl(IEmployeeServices services) {
        this.services = services;
    }

    @GetMapping("/index")
    public String getRoot() {
        return "index";
    }

    //SAVE
    // http://localhost:8080/api/v1/employees
    @Override
    @PostMapping("/employees")
    public ApiResult createEmployee(@Valid  @RequestBody EmployeeDto employeeDto) {
        services.createEmployee(employeeDto);
        return new ApiResult(200,"/api/v1/employees","Müşteri Register Eklendi");
    }


    //LIST
    // http://localhost:8080/api/v1/employees
    @Override
    @GetMapping("/employees")
    public List<EmployeeDto> getAllEmployees() {
        return  services.getAllEmployee();
    }

    //FIND
    // http://localhost:8080/api/v1/employees/1
    @Override
    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable(name = "id") Long id) {
        ResponseEntity<EmployeeDto> response=  services.getEmployeeById(id);
        return response;
    }

    //UPDATE
    // http://localhost:8080/api/v1/employees/1
    @Override
    @PutMapping("/employees/{id}")
    public ApiResult updateEmployee(@Valid @PathVariable(name = "id") Long id, @RequestBody  EmployeeDto employeeDto) {
        ResponseEntity<EmployeeDto> response=services.updateEmployee(id,employeeDto);
        return new ApiResult(200,"/api/v1/employees","Müşteri Register Güncellendi");
    }


    //DELETE
    // http://localhost:8080/api/v1/employees/1
    @Override
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable(name = "id") Long id) {
        services.deleteEmployee(id);
        Map<String,Boolean> response= new HashMap<>();
        response.put("silindi",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
