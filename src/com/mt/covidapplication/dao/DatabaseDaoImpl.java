package com.mt.covidapplication.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;
import java.sql.Connection;


public class DatabaseDaoImpl implements DatabaseDao {

	Connection con = null;
	CallableStatement cs = null;
	ResultSet rs = null;
	int rowCount = 0;
	
	public DatabaseDaoImpl()
	{
		try {
			 Class.forName(CLASSNAME);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		
			try {
				con = DriverManager.getConnection(URL, USER, PWD);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return con;
	}

	@Override
	public ResultSet getResultSet() {
		// TODO Auto-generated method stub
		try {
			rs = cs.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		try
		{
			rowCount = cs.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rowCount;
	}
	@Override
	public CallableStatement callableStatement(String sql) 
	{
		// TODO Auto-generated method stub
		try
		{
			cs = con.prepareCall(sql);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return cs;
	}

}
