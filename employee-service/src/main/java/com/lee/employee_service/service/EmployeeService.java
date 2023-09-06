package com.lee.employee_service.service;


import com.lee.employee_service.dto.APIResponseDto;
import com.lee.employee_service.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDto getEmployeeById(Long employeeId);
}
