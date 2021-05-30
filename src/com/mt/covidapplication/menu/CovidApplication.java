package com.mt.covidapplication.menu;

import java.util.Scanner;

import com.mt.covidapplication.exceptionwrapping.CityDetailsException;
import com.mt.covidapplication.exceptionwrapping.InsertionFailure;
import com.mt.covidapplication.exceptionwrapping.MyException;
import com.mt.covidapplication.exceptionwrapping.MySqlException;
import com.mt.covidapplication.exceptionwrapping.StateNotFoundException;
import com.mt.covidapplication.services.Service;

public class CovidApplication {

	static Scanner scan = new Scanner(System.in);
	static Service ser = new Service();

	public static void main(String[] args) throws StateNotFoundException, InsertionFailure, CityDetailsException, MySqlException {
		// TODO Auto-generated method stub
		boolean b = true;
		do {
			menu();
			System.out.println("Enter the choice");
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				showState();
				String str = add();
				System.out.println(str);

				break;
			case 2:
				System.out.println("Enter State name");
				String state = scan.next();
				stateDetail(state);
				/*
				 * System.out.println("Entter state name"); String state = scan.next();
				 * totalDetails(state);
				 */

				break;
			case 3:
				System.out.println("Enter the state");
				String st = scan.next();
				System.out.println("Enter the city");
				String ct = scan.next();
				ser.getCityDetail(st, ct);

				break;
			case 4:
				System.out.println("Thanks for using applicaton");
				b = false;
				break;
			default:
				System.out.println("Please enter valid input");
				break;
			}
		} while (b);

	}

	private static String add() throws InsertionFailure, MySqlException {

		System.out.println("Enter the name of state");
		String sname = scan.next();
		System.out.println("Enter the day id");
		int id = scan.nextInt();
		System.out.println("Enter no of test done");
		int noOfTest = scan.nextInt();
		System.out.println("Enter no of Covid patient");
		int noOfCovid = scan.nextInt();
		System.out.println("Enter the number of patient got infected");
		int noOfPatientInft = scan.nextInt();
		System.out.println("Enter he city");
		String city = scan.next();
		String status = ser.addDetail(id, sname, noOfTest, noOfCovid, noOfPatientInft, city);
		return status;

	}

	private static void totalDetails(String state) throws MyException, MySqlException {
		// TODO Auto-generated method stub
		ser.totalDetails(state);

	}

	private static void stateDetail(String state) throws StateNotFoundException, MySqlException {
		// TODO Auto-generated method stub
		ser.stateDetail(state);

	}

	private static void showState() {
		// TODO Auto-generated method stub
		System.out.println("1:Bihar");
		System.out.println("2:WestBengal");
		System.out.println("3:Mumbai");
		System.out.println("4:Chennai");
	}

	private static void menu() {
		// TODO Auto-generated method stub
		System.out.println("1:Insert record in speific state");
		System.out.println("2:Display detail by specific state");
		System.out.println("3:Display sum of patient of specific city");
		System.out.println("4:Exit");

	}

}
