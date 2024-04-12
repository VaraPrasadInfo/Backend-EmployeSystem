package com.infy.pip.mapper;

import com.infy.pip.dto.EmployeDto;
import com.infy.pip.model.Employee;

public class EmployeMapper {

    public static EmployeDto mapToEmployeDto(Employee employee)
    {
        return new EmployeDto(

                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()

        );
    }
    public static  Employee mapToEmployee(EmployeDto employeDto)
    {
        return new Employee(
                employeDto.getId(),
                employeDto.getFirstName(),
                employeDto.getLastName(),
                employeDto.getEmail()
        );
    }
}
