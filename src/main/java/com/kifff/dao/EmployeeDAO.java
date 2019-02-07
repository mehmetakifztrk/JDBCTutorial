package com.kifff.dao;

import com.kifff.model.Employee;

import java.util.List;

public interface EmployeeDAO {
    public abstract  void createEmployee(Employee employee);
    public abstract Employee getEmployeeByID(Integer employeeId);
    public abstract void updateEmployeeEmailById(String newEmail,Integer employeeId);
    public abstract void deleteEmployeeById(Integer employeeId);
    public abstract List<Employee> getAllEmployeeInfo();
}
