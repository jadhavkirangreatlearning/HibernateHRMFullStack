package com.csi.service;

import java.util.List;

import com.csi.model.Employee;

public interface EmployeeService {

	public void signUp(Employee employee);

	public boolean signIn(String empEmailId, String empPassword);

	public Employee getDataById(int empId);

	public List<Employee> getAllData();

	public void updateData(int empId, Employee employee);

	public void deleteDataById(int empId);

	public void deleteAllData();

}
