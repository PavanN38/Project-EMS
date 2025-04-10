package com.project.ems_backend.service.impl;

import com.project.ems_backend.dto.EmployeeDto;
import com.project.ems_backend.entity.Employee;
import com.project.ems_backend.exception.ResourceNotFoundException;
import com.project.ems_backend.mapper.EmployeeMapper;
import com.project.ems_backend.repo.EmployeeRepo;
import com.project.ems_backend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {


    private EmployeeRepo employeeRepo;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto)
    {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
       Employee savedEmployee = employeeRepo.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId)
    {
     Employee employee =   employeeRepo.findById(employeeId).
               orElseThrow( () ->
                       new ResourceNotFoundException("Employee not found : "+ employeeId));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getEmployees()
    {
       List<Employee> employees =  employeeRepo.findAll();

       return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toUnmodifiableList());
    }

    @Override
    public EmployeeDto upadteEmployee(Long id, EmployeeDto updatedEmployee)
    {
       Employee employee = employeeRepo.findById(id).orElseThrow( () -> new ResourceNotFoundException("Employee Not found" + id));

        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setPhoneNumber(updatedEmployee.getPhoneNumber());
        employee.setEmail(updatedEmployee.getEmail());

        Employee updatedEmp = employeeRepo.save(employee);


        return EmployeeMapper.mapToEmployeeDto(updatedEmp);
    }

    @Override
    public void deleteEmployee(Long Id)
    {
        Employee employee = employeeRepo.findById(Id).orElseThrow(() -> new ResourceNotFoundException("No employee with" + " " + Id + "to delete"));

      employeeRepo.deleteById(Id);
    }
}
