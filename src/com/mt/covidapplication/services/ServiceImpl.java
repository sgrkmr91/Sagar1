package com.mt.covidapplication.services;

import com.mt.covidapplication.exceptionwrapping.CityDetailsException;
import com.mt.covidapplication.exceptionwrapping.InsertionFailure;
import com.mt.covidapplication.exceptionwrapping.MyException;
import com.mt.covidapplication.exceptionwrapping.MySqlException;
import com.mt.covidapplication.exceptionwrapping.StateNotFoundException;

public interface ServiceImpl {
	public String addDetail(int id, String sname, int noOfTest, int noOfCovid, int noOfPatientInft, String city)
			throws InsertionFailure, MySqlException;

	public void stateDetail(String state) throws StateNotFoundException, MySqlException;

	public void getCityDetail(String st, String ct) throws CityDetailsException, MySqlException;
}
