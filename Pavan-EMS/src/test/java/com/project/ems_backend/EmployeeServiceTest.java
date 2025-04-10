package com.project.ems_backend;



import com.project.ems_backend.dto.EmployeeDto;
import com.project.ems_backend.entity.Employee;
import com.project.ems_backend.repo.EmployeeRepo;
import com.project.ems_backend.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Arrays;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class EmployeeServiceTest {

    @Mock
    private EmployeeRepo employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    private Employee employee;
    private EmployeeDto employeeDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        employee = new Employee(1L, "John", "Developer", 939994949L, "john@gmail.com");
        employeeDto = new EmployeeDto(1L, "John", "Developer",983889299L, "john@gmail.com");
    }

    @Test
    void testCreateEmployee() {
        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);

        EmployeeDto result = employeeService.createEmployee(employeeDto);

        assertThat(result.getFirstName()).isEqualTo("John");
    }

    @Test
    void testGetEmployeeById() {
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));

        EmployeeDto result = employeeService.getEmployeeById(1L);

        assertThat(result.getFirstName()).isEqualTo("John");
    }

    @Test
    void testGetEmployees() {
        when(employeeRepository.findAll()).thenReturn(Arrays.asList(employee));

        var result = employeeService.getEmployees();

        assertThat(result.size()).isEqualTo(1);
    }

    @Test
    void testUpdateEmployee() {
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));
        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);

        EmployeeDto result = employeeService.upadteEmployee(1L, employeeDto);

        assertThat(result.getLastName()).isEqualTo("John");
    }

    @Test
    void testDeleteEmployee() {
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));
        doNothing().when(employeeRepository).delete(employee);

        employeeService.deleteEmployee(1L);

        verify(employeeRepository, times(1)).delete(employee);
    }
}
