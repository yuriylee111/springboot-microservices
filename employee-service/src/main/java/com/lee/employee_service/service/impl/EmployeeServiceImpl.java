package com.lee.employee_service.service.impl;

import com.lee.employee_service.dto.APIResponseDto;
import com.lee.employee_service.dto.DepartmentDto;
import com.lee.employee_service.dto.EmployeeDto;
import com.lee.employee_service.entity.Employee;
import com.lee.employee_service.mapper.EmployeeMapper;
import com.lee.employee_service.repository.EmployeeRepository;
import com.lee.employee_service.service.APIClient;
import com.lee.employee_service.service.EmployeeService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private APIClient apiClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);

    }

    @CircuitBreaker(name="${spring.application.name}", fallbackMethod = "getDefaultDepartment")
    @Override
    public APIResponseDto getEmployeeById(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId).get();
        DepartmentDto departmentDto = apiClient.getDepartment(employee.getDepartmentCode());
        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);

        return apiResponseDto;
    }

    public APIResponseDto getDefaultDepartment(Long employeeId, Exception e) {
        Employee employee = employeeRepository.findById(employeeId).get();
        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);
        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setDepartmentName("RD Department");
        departmentDto.setDepartmentCode("RD001");
        departmentDto.setDepartmentDescription("Research and Development Department");

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);
        return apiResponseDto;
    }
}
