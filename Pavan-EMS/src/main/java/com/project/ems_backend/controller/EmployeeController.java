package com.project.ems_backend.controller;


import com.project.ems_backend.dto.EmployeeDto;
import com.project.ems_backend.entity.Employee;
import com.project.ems_backend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")  // Base URL for all the urls.
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    //Add employee REST API
    @PostMapping("/add")
    public ResponseEntity<EmployeeDto> createEmployeeRecord(@RequestBody EmployeeDto employeeDto)
    {
        EmployeeDto savedEmployee =  employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }


    //get employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById( @PathVariable("id") Long employeeId)
    {
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);

        return ResponseEntity.ok(employeeDto);
    }


    //get all the employees
    @GetMapping("/")
    public ResponseEntity<List<EmployeeDto>> getEmployees()
    {
        List<EmployeeDto> employees= employeeService.getEmployees();
        return  ResponseEntity.ok(employees);
    }

    //update employee
    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeDto> upadteEmployee(@PathVariable("id") Long employeeId,@RequestBody EmployeeDto employeeDto)
    {
       EmployeeDto updatedRecord =  employeeService.upadteEmployee(employeeId,employeeDto);
        return ResponseEntity.ok(updatedRecord);
    }


    //delete employee
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId)
    {
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Deleted Employee Record with Id: "+ employeeId);
    }
}
