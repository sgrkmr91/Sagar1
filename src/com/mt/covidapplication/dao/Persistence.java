package com.mt.covidapplication.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import com.mt.covidapplication.exceptionwrapping.CityDetailsException;
import com.mt.covidapplication.exceptionwrapping.InsertionFailure;
import com.mt.covidapplication.exceptionwrapping.MyException;
import com.mt.covidapplication.exceptionwrapping.MySqlException;
import com.mt.covidapplication.exceptionwrapping.StateNotFoundException;

public class Persistence {

	Connection con = null;
	CallableStatement cs = null;
	ResultSet rs = null;
	DatabaseDaoImpl databaseDaoImpl = new DatabaseDaoImpl();

	public Persistence() {
		con = databaseDaoImpl.getConnection();
	}

	public String addPatient(int id, String sname, int noOfTest, int noOfCovid, int noOfPatientInft, String city)
			throws InsertionFailure, MySqlException {
		// TODO Auto-generated method stub
		String status = "";
		try {
			cs = databaseDaoImpl.callableStatement("{call " + sname+ "Insert(" + id + "," + noOfTest + ","
					+ noOfPatientInft + "," + noOfCovid + ",'" + city + "')}");
			int rowCount = databaseDaoImpl.getRowCount();
			if (rowCount == 1) {
				status = "Success";
			} else {
				status = "Failure";
			}
		} catch (Exception e) {
			throw new InsertionFailure("Unable to insert in database", e);
		}
		finally
		{
			try {
				cs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new MySqlException("Unable to close",e);
			}
		}
		return status;
	}

	public void stateDetail(String state) throws StateNotFoundException, MySqlException {
		// TODO Auto-generated method stub

		try {
			cs = databaseDaoImpl.callableStatement("{call get" + state + "Detail()}");
			// cs.setString(1,state);
			rs = cs.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " "
						+ rs.getString(4) + " " + rs.getString(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new StateNotFoundException("State detail is not existed", e);
		}finally
		{
			try {
				cs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new MySqlException("Unable to close",e);
			}
		}

	}

	public void totalDetails(String state) throws MyException, MySqlException {
		// TODO Auto-generated method stub
		try {
			cs = databaseDaoImpl.callableStatement("{call stateDetail(?)}");
			cs.registerOutParameter(1, Types.BIGINT);
			System.out.println(cs.execute());
			System.out.println("Total :" + cs.getInt(1));
			/*
			 * rs = cs.executeQuery(); while(rs.next()) {
			 * System.out.println(rs.getString(1)); }
			 */
		} catch (Exception e) {
			throw new MyException("Failed to retrieve the data", e);
		}
		finally
		{
			try {
				cs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new MySqlException("Unable to close",e);
			}
		}

	}

	public void getCityDetail(String st, String ct) throws CityDetailsException, MySqlException {
		// TODO Auto-generated method stub
		try {
			cs = databaseDaoImpl.callableStatement("{call biharcitySum(?,?)}");
			cs.setString(1, ct);
			cs.registerOutParameter(2, Types.BIGINT);
			cs.execute();
			System.out.println("Noof Infected person : " + cs.getInt(2));
		} catch (Exception e) {
			throw new CityDetailsException("City is not available", e);
		}
		finally
		{
			try {
				cs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new MySqlException("Unable to close",e);
			}
		}
	}

}
