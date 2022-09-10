package com.lti.EmployeeApp;

import java.sql.SQLException;

import com.lti.dao.Employee_Dao;
import com.lti.entity.Employee;

public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException, SQLException
    {
        System.out.println( "Hello World!" );
        Employee_Dao dao = new Employee_Dao();
        Employee e1 = new Employee();
        e1.setUsername("mangesh11");
        e1.setPassword("mangesh11");
        e1.setEmail("mangesh@gmail.com");
        dao.addEmp(e1);
        System.out.println("Employee Added Succcessfully");
//        int a = dao.deleteEmployee(e1.getUsername());
//        if(a>0) {
//        	System.out.println("Employee deleted successfully");
//        }else {
//        	System.out.println("Table Not available");
//        }
    }
}
