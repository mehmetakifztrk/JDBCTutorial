package com.kifff.client;

import com.kifff.dao.EmployeeDAO;
import com.kifff.dao.impl.EmployeeDAOImpl;
import com.kifff.model.Employee;
import com.kifff.util.DBUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

/**
 * Hello world!
 *
 */
public class ClientTest
{
    public static void main( String[] args ) {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
      //  Employee employee = getEmployee();
      //  employeeDAO.createEmployee(employee);
          Employee employee = employeeDAO.getEmployeeByID(1);
        System.out.println(employee.toString());
      //  employeeDAO.updateEmployeeEmailById("mehmetakifztrk@outlook.com",1);
      //  employeeDAO.deleteEmployeeById(3);
       // getAllEmployeesInfo(employeeDAO);
    }

    private static void getAllEmployeesInfo(EmployeeDAO employeeDAO) {
        List<Employee> empList = employeeDAO.getAllEmployeeInfo();
        empList.forEach(System.out::println);
    }

    private static void getEmployeeById(EmployeeDAO employeeDAO) {
        Employee employee2 = employeeDAO.getEmployeeByID(1);
        if (employee2 != null){
            System.out.println(employee2.toString());
        }else {
            System.out.println("hataa");
        }
    }

    private static Employee getEmployee(){
        Employee employee = new Employee();
        employee.setEmployeeName("Akif");
        employee.setEmail("mehmetakifztrk@outlook.com");
        employee.setSalary(new Double(4000.00));
        employee.setBonus(new BigDecimal(290));
        employee.setDoj(new Date());
        return employee;
    }
}
