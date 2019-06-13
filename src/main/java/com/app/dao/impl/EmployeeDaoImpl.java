package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IEmployeeDao;
import com.app.model.Employee;

@Repository
public class EmployeeDaoImpl implements IEmployeeDao {
	@Autowired
	private HibernateTemplate ht;
	
	
	@Override
	public void saveEmployee(Employee e) {
		ht.save(e);
	}

	@Override
	public void updateEmployee(Employee e) {
		ht.update(e);
	}

	@Override
	public void deleteEmployee(Integer id) {
		ht.delete(new Employee(id));
	}

	@Override
	public Employee getEmployee(Integer id) {
		return ht.get(Employee.class, id);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return ht.loadAll(Employee.class);
	}

}
