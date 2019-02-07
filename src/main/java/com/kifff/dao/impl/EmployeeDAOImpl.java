package com.kifff.dao.impl;

import com.kifff.dao.EmployeeDAO;
import com.kifff.model.Employee;
import com.kifff.util.DBUtil;
import com.mysql.cj.xdevapi.SqlDataResult;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public void createEmployee(Employee employee) {
        String SQL="INSERT INTO employee_table (employee_name,email,salary,date_of_joining,bonus) " +
                "VALUES (?,?,?,?,?)";
        try(Connection connection = DBUtil.getConnection(); PreparedStatement ps = connection.prepareStatement(SQL)) {
            ps.setString(1,employee.getEmployeeName());
            ps.setString(2,employee.getEmail());
            ps.setDouble(3,employee.getSalary());
            ps.setDate(4,new Date(employee.getDoj().getTime()));
            ps.setBigDecimal(5,employee.getBonus());

            int executeUpdate = ps.executeUpdate();

            if (executeUpdate == 1){
                System.out.println("employee is created...");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Employee getEmployeeByID(Integer employeeId) {
        Employee employee = null;
        String SQL="SELECT * FROM employee_table WHERE employee_id = ?";
        try(Connection connection = DBUtil.getConnection(); PreparedStatement ps = connection.prepareStatement(SQL)) {
            ps.setInt(1,employeeId);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                employee = getEmployee(resultSet);
             }

        }catch (Exception e){
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public void updateEmployeeEmailById(String newEmail, Integer employeeId) {
        String SQL="UPDATE employee_table SET email=? WHERE employee_id=?";
        try(Connection connection = DBUtil.getConnection(); PreparedStatement ps = connection.prepareStatement(SQL)) {

            ps.setString(1,newEmail);
            ps.setInt(2,employeeId);

            int executeUpdate = ps.executeUpdate();

            if (executeUpdate == 1){
                System.out.println("employee is updated...");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployeeById(Integer employeeId) {
        String SQL="DELETE FROM employee_table WHERE employee_id=?";
        try(Connection connection = DBUtil.getConnection(); PreparedStatement ps = connection.prepareStatement(SQL)) {

            ps.setInt(1,employeeId);

            int executeUpdate = ps.executeUpdate();

            if (executeUpdate == 1){
                System.out.println("employee is deleted with ID = "+employeeId);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> getAllEmployeeInfo() {
        List<Employee> empList = new ArrayList<>();
        String SQL="SELECT * FROM employee_table";
        try(Connection connection = DBUtil.getConnection(); PreparedStatement ps = connection.prepareStatement(SQL)) {
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                Employee employee = getEmployee(resultSet);

                empList.add(employee);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return empList;
    }

    private Employee getEmployee(ResultSet resultSet) throws SQLException {
        int empId = resultSet.getInt("employee_id");
        String eName = resultSet.getString("employee_name");
        String email = resultSet.getString("email");
        Double salary = resultSet.getDouble("salary");
        java.util.Date doj = resultSet.getDate("date_of_joining");
        BigDecimal bonus = resultSet.getBigDecimal("bonus");

        Employee employee = new Employee();
        employee.setEmployee_id(empId);
        employee.setEmployeeName(eName);
        employee.setEmail(email);
        employee.setSalary(salary);
        employee.setDoj(doj);
        employee.setBonus(bonus);
        return employee;
    }
}
