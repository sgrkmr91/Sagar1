package com.mt.covidapplication.exceptionwrapping;

import java.sql.SQLException;

public class MySqlException extends Exception {

	public MySqlException(String string, SQLException e) {
		// TODO Auto-generated constructor stub
		super(string,e);
	}

	
}
