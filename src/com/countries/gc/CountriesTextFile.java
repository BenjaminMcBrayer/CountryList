//Benjamin McBrayer, 5.9.2018

package com.countries.gc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CountriesTextFile {

	public static void main(String[] args) {
		CountriesTextFile.createDirectory("resources");

		CountriesTextFile.createFile("resources", "countries.txt");
		CountriesTextFile.createFile("resources", "countries.tmp");
	}

	public static void createDirectory(String path) {
		Path dirPath = Paths.get(path);

		if (Files.notExists(dirPath)) {
			try {
				Files.createDirectories(dirPath);
			} catch (IOException e) {
				System.out.println("Something went wrong!");
			}
		}
	}

	public static void createFile(String dir, String fileName) {
		Path filePath = Paths.get(dir, fileName);

		if (Files.notExists(filePath)) {
			try {
				Files.createFile(filePath);
				System.out.println("Your file was created successfully.");
			} catch (IOException e) {
				System.out.println("Something went wrong! The file was not created.");
			}
		}
	}

	// Reads a list of countries from a file
	public static void readFromFile(String dir, String fileName) {
		Path readFile = Paths.get(dir, fileName);
		File file = readFile.toFile(); // Convert to a file object.

		try {
			FileReader fr = new FileReader(file);

			BufferedReader br = new BufferedReader(fr);

			String line = br.readLine();

			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			System.out.println("Something went wrong.");
		}

	}

	// Adds a country to a file.
	public static void writeToFile(String country, String dir, String fileName) {
		Path writeFile = Paths.get(dir, fileName);
		File file = writeFile.toFile();

		try {
			PrintWriter outW = new PrintWriter(new FileOutputStream(file, true));
			outW.println("\n" + country);
			outW.close(); // Flush data and close stream.

		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		}

	}

//	 Deletes a country from a file.
	public static void removeFromFile(String lineToRemove, String dir, String originalFileName, String tempFileName) {
		Path removeLineFromOriginalFile = Paths.get(dir, originalFileName);
		File file = removeLineFromOriginalFile.toFile();
		Path writeFile = Paths.get(dir, tempFileName);
		File tempFile = writeFile.toFile();

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			PrintWriter pw = new PrintWriter(new FileOutputStream(tempFile, true));

			String line = null;

			while ((line = br.readLine()) != null) {
				if (!line.equalsIgnoreCase(lineToRemove)) {
					pw.println(line);
				}
			}

			pw.close();
			br.close();

			// Delete original file.
			if (!file.delete()) {
				System.out.println("Could not delete file.");
			}

			// Rename new file.
			if (tempFile.renameTo(file)) {
				System.out.println("Could not rename ");
			}

		} catch (IOException e) {
			System.out.println("No need to panic but something's not right here.");
		}
	}
}
