package com.kifff.client;

import com.kifff.util.DBUtil;

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
    }
}
