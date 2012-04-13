package com.xleon.demo.sqlitedemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo1 {
	public static void main(String[] args) throws Exception {
	    Class.forName("org.sqlite.JDBC");
	    Connection connection = DriverManager
	            .getConnection("jdbc:sqlite:db/welcome.db");
	    Statement statement = connection.createStatement();
	    ResultSet resultSet = statement.executeQuery("select * from user_info");
	    while (resultSet.next()) {
	    	System.out.println("编号： "+resultSet.getString("id"));
	        System.out.println("姓名： "+resultSet.getString("name"));
	        System.out.println("性别： "+resultSet.getString("sex"));
	        System.out.println("=================================================");
	        
	        //github demo
	    }
	    resultSet.close();
	    statement.close();
	    connection.close();
	}
}
