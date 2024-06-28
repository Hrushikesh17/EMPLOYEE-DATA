package com.Jsp.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Jsp.Dto.Employee;

@Repository
public class EmployeeDao {
	@Autowired
	EntityManager manager;
	@Autowired
	EntityTransaction transaction;
	
	public void saveEmployee(Employee  employee)
	{
		transaction.begin();
		manager.persist(employee);
		transaction.commit();
	}
	
	public Employee getEmployeeById(int id) {
	   Employee e =manager.find(Employee.class, id);
	   return e;
	}
	
	public void removeEmployee(int id) {
        transaction.begin();
        Employee employeeToRemove = manager.find(Employee.class, id);
        manager.remove(employeeToRemove);
        transaction.commit();
    }
	public void updateEmployee(Employee employee) {
		transaction.begin();
		manager.merge(employee);
		transaction.commit();		
	}
	public List<Employee> getAllEmployee(){
	Query q	= manager.createQuery("select e from Employee e");
	List<Employee> emploList = q.getResultList();
	return emploList;
	}
}
