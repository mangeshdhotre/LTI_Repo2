package com.lti.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Datatbase_Conn {
 public static Connection getConn() throws SQLException, ClassNotFoundException {

	 String url = "jdbc:oracle:thin:@DESKTOP-AQBR7O3:1521:xe";
	 String un="hr";
     String pwd="hr";
	 Connection conn = DriverManager.getConnection(url,un,pwd);
	 if(conn!=null) {
		 System.out.println("Connected");
	 }
	 return conn;
 }
 public static void main(String[] args) throws SQLException, ClassNotFoundException {
	getConn();
}
 
 
}
