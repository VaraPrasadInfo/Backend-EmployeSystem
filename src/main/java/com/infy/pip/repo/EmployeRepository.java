package com.infy.pip.repo;

import com.infy.pip.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface EmployeRepository extends JpaRepository<Employee,Long> {
}
