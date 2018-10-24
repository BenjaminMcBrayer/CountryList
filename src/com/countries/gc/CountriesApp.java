package com.countries.gc;

import java.util.Scanner;

/**
 * 
 * @author BenjaminMcBrayer
 * @version 1.0
 *
 */

public class CountriesApp {

	public static void main(String[] args) {
		// Declare and initialize variables;
		Scanner scnr = new Scanner(System.in);
		int userNum = 0;

		// Introduce program.
		System.out.println("Welcome to the Countries Maintenance Application!");

		do {
			System.out.println(
					"\nMENU\n1 - See the list of countries\n2 - Add a country\n3 - Remove a country\n4 - Exit");

			userNum = Validator.getInt(scnr, "\nPlease enter menu number: ", 1, 4);

			maintainCountries(scnr, userNum);

		} while (userNum == 1 || userNum == 2 || userNum == 3);

		scnr.close();
	}

	public static void maintainCountries(Scanner scnr, int userNum) {
		switch (userNum) {

		case 1:
			CountriesTextFile.displayCountries(CountriesTextFile.readFromFileToArrayList("resources/countries.txt"));
			break;

		case 2:
			String userInput1 = Validator.getString(scnr, "Please enter a country: ");
			String userInput2 = Validator.getString(scnr, "Please enter the name of the capital: ");
			Country userCountry1 = new Country(userInput1, userInput2);
			CountriesTextFile.writeToFile(userCountry1, "resources", "countries.txt");
			break;

		case 3:
			userInput1 = Validator.getString(scnr, "Please enter the name of the country you wish to delete: ");
			String emptyCapital = "";
			Country userCountry2 = new Country(userInput1, emptyCapital);
			CountriesTextFile.writeToFile(userCountry2, "resources", "tempcountries.txt");
			CountriesTextFile.removeFromFile(userInput1, "resources", "countries.txt", "tempcountries.txt");
			break;

		case 4:
			System.out.println("Buh-Buy!");
			break;
		}
	}

}
