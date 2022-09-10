package com.lti.dao;
//Dao - data access object

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lti.entity.Employee;

public class Employee_Dao {
  private Connection conn;

public Employee_Dao() throws ClassNotFoundException, SQLException {
	conn = Datatbase_Conn.getConn();
	System.out.println("Getting connection from constructor");
}
  public void addEmp(Employee e) throws SQLException {
	  PreparedStatement ps = conn.prepareStatement("insert into Employee_Table(username,password,email) values(?,?,?)");
      ps.setString(1, e.getUsername());
      ps.setString(2, e.getPassword());
      ps.setString(3, e.getEmail());
      ps.executeUpdate();
      ps.close();
  }
  public void deleteEmployee(String username) throws ClassNotFoundException, SQLException {
  
	  PreparedStatement ps=null;
	  try {
	  ps = conn.prepareStatement("delete from Employee_Table where username = ?");
	  ps.setString(1, username);
	 ps.executeUpdate();
	  ps.close();
	  
	  }catch(SQLException e) {
		  e.printStackTrace();
	  }
	
	 
  }
  public Employee getEmpbyname(String username) throws SQLException {
	  Employee emp1 = new Employee();
	  PreparedStatement ps = conn.prepareStatement("select * from Employee_Table where username = ? ");
	  ps.setString(1, username);
	  ResultSet rs = ps.executeQuery();
	  if(rs.next()) {
		  emp1.setUsername(rs.getString("username"));
		  emp1.setPassword(rs.getString("password"));
		  emp1.setEmail(rs.getString("email"));

	  }
	  return emp1;
  }

}
