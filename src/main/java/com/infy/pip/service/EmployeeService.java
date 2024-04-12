package com.infy.pip.service;

import com.infy.pip.dto.EmployeDto;

import java.util.List;

public interface EmployeeService {

     public EmployeDto createEmployee(EmployeDto employeDto);
     public EmployeDto getEmployeeById(Long employeId);
     public EmployeDto updateEmployee(Long employeeId,EmployeDto updateEmploye);
     public List<EmployeDto> getAllEmployeData();
}
