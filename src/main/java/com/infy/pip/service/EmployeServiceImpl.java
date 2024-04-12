package com.infy.pip.service;

import com.infy.pip.dto.EmployeDto;
import com.infy.pip.exception.ResourceNotFoundException;
import com.infy.pip.mapper.EmployeMapper;
import com.infy.pip.model.Employee;
import com.infy.pip.repo.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeServiceImpl implements  EmployeeService{
    @Autowired
    private EmployeRepository employeRepository;

   /* public EmployeServiceImpl(EmployeRepository employeRepository) {
        this.employeRepository = employeRepository;
    }*/

    @Override
    public EmployeDto createEmployee(EmployeDto employeDto) {

        Employee employee= EmployeMapper.mapToEmployee(employeDto);
        Employee saveEmployee=employeRepository.save(employee);
        return EmployeMapper.mapToEmployeDto(saveEmployee);
    }

    @Override
    public EmployeDto getEmployeeById(Long employeId) {
        Employee employee= employeRepository.findById(employeId)
                 .orElseThrow(()->
                 new ResourceNotFoundException("Employee not exist with given id"+employeId));
        return EmployeMapper.mapToEmployeDto(employee);
    }

    @Override
    public EmployeDto updateEmployee(Long employeeId, EmployeDto updateEmploye) {
        Employee employee=employeRepository.findById(employeeId)
                .orElseThrow(()->new ResourceNotFoundException("Employee not exist with given id"+employeeId));
        employee.setFirstName(updateEmploye.getFirstName());
        employee.setLastName(updateEmploye.getLastName());
        employee.setEmail(updateEmploye.getEmail());
       Employee updatedEmployeeObj= employeRepository.save(employee);

        return EmployeMapper.mapToEmployeDto(updatedEmployeeObj);
    }

    @Override
    public List<EmployeDto> getAllEmployeData() {

        List<Employee> employees=employeRepository.findAll();
        return employees.stream().map(EmployeMapper::mapToEmployeDto).collect(Collectors.toList());
    }
}
