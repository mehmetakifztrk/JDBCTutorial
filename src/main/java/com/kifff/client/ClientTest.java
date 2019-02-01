package com.kifff.client;

import com.kifff.util.DBUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class ClientTest
{
    public static void main( String[] args ) {
        getEmployeeById();
    }

    private static void getEmployeeById() {
        try(Connection connection = DBUtil.getConnection();Statement st = connection.createStatement();){
            String SQL = "SELECT * FROM employee_table WHERE employee_id=1";
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()){
                int empId = rs.getInt("employee_id");
                String eName = rs.getString("employee_name");
                String email = rs.getString("email");
                Double salary = rs.getDouble("salary");
                BigDecimal bonus = rs.getBigDecimal("bonus");

                System.out.println(empId+"/n"+eName+"/n"+email+"/n"+salary+"/n"+bonus);
            }else{
                System.out.println("bu id de kayıt yok");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
