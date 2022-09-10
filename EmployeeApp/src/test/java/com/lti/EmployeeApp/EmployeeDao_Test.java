package com.lti.EmployeeApp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.lti.dao.Datatbase_Conn;
import com.lti.dao.Employee_Dao;
import com.lti.entity.Employee;

public class EmployeeDao_Test {
	 private static Employee_Dao dao;
//	@BeforeAll
//    static void init() throws SQLException, ClassNotFoundException {
//        Connection conn = Datatbase_Conn.getConn();
//        try {
//            // set auto commit false so any operation in this test will be discarded.
//            conn.setAutoCommit(false);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
////        emp_dao = new Employee_dao(conn);
//    }
//     
//    @AfterAll
//    static void teardown() throws SQLException, ClassNotFoundException {
//        Connection conn = Datatbase_Conn.getConn();
//        try {
//            conn.setAutoCommit(true);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
    @Test
    public void getConnectionTest() throws ClassNotFoundException, SQLException {
        Connection conn = Datatbase_Conn.getConn();
        assertNotNull(conn,"Connection Successful");
        
    }
    @BeforeAll
    static void getDao() throws ClassNotFoundException, SQLException {
    	 dao = new Employee_Dao();
    }
    
    @Test
    public void addEmpTest() throws ClassNotFoundException, SQLException {
    	Employee emp  = new Employee();
    	emp.setUsername("emp");
    	emp.setPassword("emppass");
    	emp.setEmail("emp@email.com");
        Connection conn = Datatbase_Conn.getConn();
//        Employee_Dao dao = new Employee_Dao();
        dao.addEmp(emp);
        Employee empfromdb = dao.getEmpbyname("emp");
        assertEquals("emppass",empfromdb.getPassword(),"Password Test Successfully");

    	
    }
    
    @Test
    public void deleteEmpTest() throws ClassNotFoundException, SQLException {
//        Employee_Dao dao = new Employee_Dao();
        Employee empfromdb = dao.getEmpbyname("emp");
        dao.deleteEmployee("emp");
        assertNull(empfromdb.getUsername()); //if user is available in database test is faied
//       assertEquals("emp",empfromdb.getUsername());
        System.out.println("");

    	
    }
	
}
