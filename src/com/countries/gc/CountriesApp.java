//Benjamin McBrayer, 5.9.2018

package com.countries.gc;

import java.util.Scanner;

public class CountriesApp {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int userNum;

		System.out.println("Welcome to the Countries Maintenance Application!");

		do {
			System.out.println("\n1 - See the list of countries\n2 - Add a country\n3 - Exit");
			
			userNum = Validator.getInt(scnr, "\nPlease enter menu number: ", 1, 3);
			
			maintainCountries(scnr, userNum);
			
		} while (userNum == 1 || userNum == 2);
		
		scnr.close();
	}

	public static void maintainCountries(Scanner scnr, int userNum) {
		String userCountry;
		switch (userNum) {

		case 1:
			CountriesTextFile.readFromFile("resources", "countries.txt");
			break;
			
		case 2:
			userCountry = Validator.getString(scnr, "Please enter a country: ");
			CountriesTextFile.writeToFile(userCountry, "resources", "countries.txt");
			break;
			
		case 3:
			System.out.println("Buh-Buy!");
			break;
		}
	}

}
