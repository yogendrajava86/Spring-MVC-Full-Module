package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IEmployeeDao;
import com.app.model.Employee;
import com.app.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeDao dao;
	
	@Transactional
	public void saveEmployee(Employee e) {
		dao.saveEmployee(e);
	}

	@Transactional
	public void updateEmployee(Employee e) {
		dao.updateEmployee(e);
	}

	@Transactional
	public void deleteEmployee(Integer id) {
		dao.deleteEmployee(id);
	}

	@Transactional(readOnly=true)
	public Employee getEmployee(Integer id) {
		return dao.getEmployee(id);
	}

	@Transactional(readOnly=true)
	public List<Employee> getAllEmployees() {
		return dao.getAllEmployees();
	}

}
