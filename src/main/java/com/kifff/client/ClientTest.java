package com.kifff.client;

import com.kifff.util.DBUtil;
import com.kifff.util.DBUtil2;
import com.kifff.util.DBUtil3;

import java.sql.Connection;

/**
 * Hello world!
 *
 */
public class ClientTest
{
    public static void main( String[] args ) {
        Connection connection = DBUtil.getConnection();
        if (connection!=null){
            System.out.println("1- JDBC bağlandı");
        }
        Connection connection2 = DBUtil2.getConnection();
        if (connection2!=null){
            System.out.println("2- JDBC bağlandı");
        }
        Connection connection3 = DBUtil3.getConnection();
        if (connection3!=null){
            System.out.println("3- JDBC bağlandı");
        }
    }
}
