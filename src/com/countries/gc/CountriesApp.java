//Benjamin McBrayer, 5.9.2018

package com.countries.gc;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author BenjaminMcBrayer
 * @version 1.0
 *
 */

public class CountriesApp {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		ArrayList<Country> countries = new ArrayList<>();
		int userNum;

		System.out.println("Welcome to the Countries Maintenance Application!");

		// The lines below test a password method. Without the name of a country in the
		// list, the menu options will not be shown.
		 String userInput = Validator.getString(scnr, "Please enter the name of the country: ");
		CountriesTextFile.validateCountry2(userInput, countries);

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
			CountriesTextFile.readFromFile("resources", "countries.txt");
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
			CountriesTextFile.writeToFile(userCountry2, "resources", "tempCountries");
			CountriesTextFile.removeFromFile(userInput1, "resources", "countries.txt", "tempCountries");
			break;

		case 4:
			System.out.println("Buh-Buy!");
			break;
		}
	}

}
