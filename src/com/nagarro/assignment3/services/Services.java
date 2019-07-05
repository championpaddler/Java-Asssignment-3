package com.nagarro.assignment3.services;

import com.nagarro.assignment3.dto.*;
import com.nagarro.assignment3.notifications.*;
import com.nagarro.assignment3.validators.*;
import java.util.*;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

import com.nagarro.assignment3.collection.DataStorage;
import com.nagarro.assignment3.constants.TaxConstants;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Services {
	private final Logger logger = Logger.getLogger(Services.class);

	Scanner input = new Scanner(System.in);
	Notifications notify = new Notifications();
	Validators validate = new Validators();
	DataStorage ds = new DataStorage();

	public String getDepLoc() {

		logger.info("Enter Departure Location");
		String name = input.nextLine();
		while (!(validate.validateName(name))) {
			logger.info("Invalid Location");
			name = input.nextLine();
		}
		return name;
	}

	public String getArrLoc() {

		logger.info("Enter Arrival Location");
		String name = input.nextLine();
		while (!(validate.validateName(name))) {
			logger.info("Invalid Location");
			name = input.nextLine();
		}
		return name;
	}

	public Date getFlightDate() throws ParseException {

		logger.info("Enter Date of Flight");
		String name = input.nextLine();
		while (!(validate.validateDate(name))) {
			logger.info("Invalid Date");
			name = input.nextLine();
		}
		SimpleDateFormat sdfrmt = new SimpleDateFormat("dd-MM-yyyy");
		Date javaDate = sdfrmt.parse(name);
		System.out.println(javaDate);
		return javaDate;
	}

	public String getFlightClass() {
		logger.info("Enter 1 for Economy, 2 for Business");
		String type = input.nextLine(); // Stored Type of Product
		while (!(validate.validateType(type))) {
			notify.invalidClass();
			type = input.nextLine();
		}
		if (type.equals("1"))
			type = "E";
		else if (type.equals("2"))
			type = "B";
		return type;
	}

	public String getPreference() {
		logger.info("Enter 1 for Fare Sort, 2 for Sort By Fare And Time");
		String type = input.nextLine(); // Stored Type of Product
		while (!(validate.validateType(type))) {
			notify.invalidFilter();
			type = input.nextLine();
		}
		if (type.equals("1"))
			type = "Fare";
		else if (type.equals("2"))
			type = "Both";
		return type;
	}

	public DataStorage loadData() throws ParseException {

		String cvsSplitBy = "\\|";
		File dir = new File(TaxConstants.DIRECTORY_TO_WATCH);
		File[] directoryListing = dir.listFiles();
		if (directoryListing != null) {
			for (File child : directoryListing) {

				String csvFile = child.getAbsolutePath();
				String line = "";

				try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
					br.readLine();

					while ((line = br.readLine()) != null) {

						String[] data = line.split(cvsSplitBy);

						Date date = new SimpleDateFormat("dd-MM-yyyy").parse(data[3]);

						Item item = new Item(data[0], data[1], data[2], date, Integer.parseInt(data[4]),
								Double.parseDouble(data[5]), Double.parseDouble(data[6]), data[7], data[8]);
						ds.setData(item);
					}

				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}
		return ds;
	}

}
