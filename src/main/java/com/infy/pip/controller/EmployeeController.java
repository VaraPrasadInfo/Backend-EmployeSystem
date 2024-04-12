package com.infy.pip.controller;

import com.infy.pip.dto.EmployeDto;
import com.infy.pip.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/employeees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //Build Add Emplyee rest API
    @PostMapping
    public ResponseEntity<EmployeDto> createEmploye(@RequestBody EmployeDto employeDto)
    {
        EmployeDto savedEmployeDto=employeeService.createEmployee(employeDto);
        return new ResponseEntity<>(savedEmployeDto, HttpStatus.CREATED);
    }
    //Buid get REST API
    @GetMapping("/{id}")
    public ResponseEntity<EmployeDto> getEmployeById(@PathVariable("id") Long empId)
    {
        EmployeDto getEmployeDtoId=employeeService.getEmployeeById(empId);
        return ResponseEntity.ok(getEmployeDtoId);
    }
    //Build update Employeee Rest API

    @PutMapping("/{empId}")
    public ResponseEntity<EmployeDto> updateEmploye(@PathVariable("empId")  Long empId,@RequestBody EmployeDto updteEmploye)
    {
        EmployeDto updatedEmpObj=employeeService.updateEmployee(empId,updteEmploye);
        return ResponseEntity.ok(updatedEmpObj);
    }

    @GetMapping()
    public ResponseEntity<List<EmployeDto>> getAllEmployeData()
    {
       List<EmployeDto> employeesGet= employeeService.getAllEmployeData();
       return ResponseEntity.ok(employeesGet);
    }
}
