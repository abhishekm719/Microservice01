package com.employeeapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employeeapp.entity.Employee;
import com.employeeapp.response.EmployeeResponse;
import com.employeeapp.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/")
	Employee AddEmployeeDetails(@RequestBody Employee employee){
		Employee emp = employeeService.addNewEmployee(employee);
		return emp;
	}
	
	@GetMapping("/employees/{id}")
	ResponseEntity<EmployeeResponse> AddEmployeeDetails(@PathVariable("id") int id){
		EmployeeResponse employeeResponse = employeeService.getEmployeeById(id);
		return ResponseEntity.status(HttpStatus.OK).body(employeeResponse);
	}
	
	@GetMapping("/employees")
	List<Employee> getAllEmployeeDetails(){
		List<Employee> employee = employeeService.getAllEmployee();
		return employee;
	}
	
	@DeleteMapping("/employees/{id}")
	String deleteEmployeeDetails(@PathVariable("id") int id){
		employeeService.deleteEmployeeById(id);
		return "Deleted Sucessfully";
	}
}
