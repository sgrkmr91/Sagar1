package com.mt.covidapplication.dao;

//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.Connection;

public interface DatabaseDao {

	String URL="jdbc:mysql://localhost:3306/covid";
	String CLASSNAME = "com.mysql.jdbc.Driver";
	String PWD = "Sagar";
	String USER = "root";
	
	public Connection getConnection();
	public ResultSet getResultSet();
	public int getRowCount();
	public CallableStatement callableStatement(String sql);
	
}
