package com.employeeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeeapp.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
