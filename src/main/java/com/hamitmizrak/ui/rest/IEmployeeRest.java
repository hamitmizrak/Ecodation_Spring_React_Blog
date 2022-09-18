package com.hamitmizrak.ui.rest;

import com.hamitmizrak.business.dto.EmployeeDto;
import com.hamitmizrak.exception.ApiResult;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface IEmployeeRest {

    //save
    ApiResult createEmployee(EmployeeDto employeeDto);

    //list
    List<EmployeeDto> getAllEmployees();

    //find
    ResponseEntity<EmployeeDto> getEmployeeById(Long id);

    //update
    ApiResult updateEmployee(Long id,EmployeeDto employeeDto);

    //delete
    ResponseEntity<Map<String,Boolean>> deleteEmployee(Long id);
}
