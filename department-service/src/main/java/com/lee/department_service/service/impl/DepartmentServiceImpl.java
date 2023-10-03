package com.lee.department_service.service.impl;

import com.lee.department_service.dto.DepartmentDto;
import com.lee.department_service.entity.Department;
import com.lee.department_service.mapper.DepartmentMapper;
import com.lee.department_service.repository.DepartmentRepository;
import com.lee.department_service.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        Department department = DepartmentMapper.mapToDepartment(departmentDto);
        Department savedDepartment = departmentRepository.save(department);

        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {

    Department department = departmentRepository.findByDepartmentCode(departmentCode);

        return DepartmentMapper.mapToDepartmentDto(department);
    }

}
