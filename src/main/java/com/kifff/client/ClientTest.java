package com.kifff.client;

import com.kifff.util.DBUtil;

import java.sql.Connection;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class ClientTest
{
    public static void main( String[] args ) {
       //createEmployee();
        updateEmployeeEmailById();
    }

    private static void updateEmployeeEmailById() {
        try(Connection connection = DBUtil.getConnection();Statement st = connection.createStatement();){
            String SQLUPDATE = "UPDATE employee_table  SET email='mehmetakifztrk44@gmail.com' WHERE employee_id=1";
            int executeUpdate = st.executeUpdate(SQLUPDATE); // sorgu çalisirsa 1 calismassa 0
            if (executeUpdate == 1){
                System.out.println("basarili");
            }else{
                System.out.println("basarisiz");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void createEmployee() {
        try(Connection connection = DBUtil.getConnection();Statement st = connection.createStatement();){
            String SQLINSTERT = "INSERT INTO employee_table (employee_name,email,salary,date_of_joining,bonus) " +
                    "VALUES ('Mehmet Akif Öztürk','mehmetakifztrk@outlook.com',60000.00,'2019-05-17',400.00)";
            int executeUpdate = st.executeUpdate(SQLINSTERT); // sorgu çalisirsa 1 calismassa 0
            if (executeUpdate == 1){
                System.out.println("basarili");
            }else{
                System.out.println("basarisiz");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
