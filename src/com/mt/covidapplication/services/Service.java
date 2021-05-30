package com.mt.covidapplication.services;


import com.mt.covidapplication.dao.Persistence;
import com.mt.covidapplication.exceptionwrapping.CityDetailsException;
import com.mt.covidapplication.exceptionwrapping.InsertionFailure;
import com.mt.covidapplication.exceptionwrapping.MyException;
import com.mt.covidapplication.exceptionwrapping.MySqlException;
import com.mt.covidapplication.exceptionwrapping.StateNotFoundException;


public class Service implements ServiceImpl 
{

	 
	Persistence pers = new Persistence(); 
	
	
	public String addDetail(int id,String sname, int noOfTest, int noOfCovid, int noOfPatientInft,String city) throws InsertionFailure, MySqlException {
		String status ="";
		try
		{
		 status = pers.addPatient(id,sname,noOfTest,noOfCovid,noOfPatientInft,city);
		}
		catch(MySqlException f)
		{
			f.getMessage();
		}
		return status;
	}


	public void stateDetail(String state) throws StateNotFoundException, MySqlException {
		// TODO Auto-generated method stub
		  pers.stateDetail(state);
	}


	public void totalDetails(String state) throws MyException, MySqlException {
		// TODO Auto-generated method stub
		pers.totalDetails(state);
		
	}


	public void getCityDetail(String st, String ct) throws CityDetailsException, MySqlException {
		// TODO Auto-generated method stub
		pers.getCityDetail(st,ct);
	}

}
