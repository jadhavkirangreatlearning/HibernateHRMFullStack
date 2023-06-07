package com.csi.service;

import java.util.List;

import com.csi.dao.EmployeeDao;
import com.csi.dao.EmployeeDaoImpl;
import com.csi.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	EmployeeDao employeeDaoImpl = new EmployeeDaoImpl();

	@Override
	public void signUp(Employee employee) {
		// TODO Auto-generated method stub
		employeeDaoImpl.signUp(employee);
	}

	@Override
	public boolean signIn(String empEmailId, String empPassword) {
		// TODO Auto-generated method stub
		return employeeDaoImpl.signIn(empEmailId, empPassword);
	}

	@Override
	public Employee getDataById(int empId) {
		// TODO Auto-generated method stub
		return employeeDaoImpl.getDataById(empId);
	}

	@Override
	public List<Employee> getAllData() {
		// TODO Auto-generated method stub
		return employeeDaoImpl.getAllData();
	}

	@Override
	public void updateData(int empId, Employee employee) {
		// TODO Auto-generated method stub
		employeeDaoImpl.updateData(empId, employee);
	}

	@Override
	public void deleteDataById(int empId) {
		// TODO Auto-generated method stub
		employeeDaoImpl.deleteDataById(empId);
	}

	@Override
	public void deleteAllData() {
		// TODO Auto-generated method stub
		employeeDaoImpl.deleteAllData();
	}

}
