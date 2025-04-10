package com.project.ems_backend;

import com.project.ems_backend.controller.EmployeeController;
import com.project.ems_backend.dto.EmployeeDto;
import com.project.ems_backend.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class EmployeeControllerTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeController employeeController;

    private EmployeeDto employeeDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        employeeDto = new EmployeeDto(1L, "John", "Developer", 9989392844L,"john@gmail.com");
    }

    @Test
    void testCreateEmployeeRecord() {
        when(employeeService.createEmployee(employeeDto)).thenReturn(employeeDto);

        ResponseEntity<EmployeeDto> response = employeeController.createEmployeeRecord(employeeDto);

        assertThat(response.getBody()).isEqualTo(employeeDto);
        assertThat(response.getStatusCodeValue()).isEqualTo(201);
    }

    @Test
    void testGetEmployeeById() {
        when(employeeService.getEmployeeById(1L)).thenReturn(employeeDto);

        ResponseEntity<EmployeeDto> response = employeeController.getEmployeeById(1L);

        assertThat(response.getBody()).isEqualTo(employeeDto);
    }

    @Test
    void testGetEmployees() {
        List<EmployeeDto> list = Arrays.asList(employeeDto);
        when(employeeService.getEmployees()).thenReturn(list);

        ResponseEntity<List<EmployeeDto>> response = employeeController.getEmployees();

        assertThat(response.getBody().size()).isEqualTo(1);
    }

    @Test
    void testUpdateEmployee() {
        when(employeeService.upadteEmployee(1L, employeeDto)).thenReturn(employeeDto);

        ResponseEntity<EmployeeDto> response = employeeController.upadteEmployee(1L, employeeDto);

        assertThat(response.getBody()).isEqualTo(employeeDto);
    }

    @Test
    void testDeleteEmployee() {
        doNothing().when(employeeService).deleteEmployee(1L);

        ResponseEntity<String> response = employeeController.deleteEmployee(1L);

        assertThat(response.getBody()).isEqualTo("Deleted Employee Record with Id: 1");
    }
}
