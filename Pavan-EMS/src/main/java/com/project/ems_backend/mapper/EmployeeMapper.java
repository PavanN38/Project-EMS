package com.project.ems_backend.mapper;

import com.project.ems_backend.dto.EmployeeDto;
import com.project.ems_backend.entity.Employee;

public class EmployeeMapper
{

    public static EmployeeDto mapToEmployeeDto(Employee employee)
    {
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getSalary(),
                employee.getDepartment()
        );
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto)
    {
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getSalary(),
                employeeDto.getDepartment()
        );
    }
}
