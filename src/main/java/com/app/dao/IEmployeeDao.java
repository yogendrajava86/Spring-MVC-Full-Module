package com.app.dao;

import java.util.List;

import com.app.model.Employee;

public interface IEmployeeDao {

	public void saveEmployee(Employee e);
	public void updateEmployee(Employee e);
	public void deleteEmployee(Integer id);
	
	public Employee getEmployee(Integer id);
	public List<Employee> getAllEmployees();
}
