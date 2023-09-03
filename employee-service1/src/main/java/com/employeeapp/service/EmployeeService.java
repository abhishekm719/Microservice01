package com.employeeapp.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeapp.entity.Employee;
import com.employeeapp.repository.EmployeeRepository;
import com.employeeapp.response.EmployeeResponse;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public EmployeeResponse getEmployeeById(int id) {
		Employee emp= employeeRepository.findById(id).get();
		EmployeeResponse employeeResponse = modelMapper.map(emp,EmployeeResponse.class);
		
//		EmployeeResponse employeeResponse = new EmployeeResponse();
//		employeeResponse.setEmpId(emp.getEmpId());
//		employeeResponse.setEmpName(emp.getEmpName());
//		employeeResponse.setBloodGroup(emp.getBloodGroup());
//		employeeResponse.setEmail(emp.getEmail());
		return employeeResponse;
	}
	
	public List<Employee> getAllEmployee(){
		List<Employee> employee = employeeRepository.findAll();
		return employee;
	}
	
	public Employee addNewEmployee(Employee employee) {
		Employee emp = employeeRepository.save(employee);
		return emp;
	}
	
	public void deleteEmployeeById(int id) {
		employeeRepository.deleteById(id);;
	}
}
