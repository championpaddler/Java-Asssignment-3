package com.nagarro.assignment3.Flights;
import com.nagarro.assignment3.collection.DataStorage;
import com.nagarro.assignment3.constants.TaxConstants;
import com.nagarro.assignment3.services.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.nagarro.assignment3.dto.*;

import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;
/**
* The class helps in Searching Flights
* @version 0.1
* @author Shubham Kumar
*/

public class Flights {


	public static void main(String[] args) throws IOException, InterruptedException, ParseException{
		    Logger logger = Logger.getLogger(Flights.class);
		    BasicConfigurator.configure();
			Scanner input = new Scanner(System.in);
		    Services service = new Services();
		    DataStorage ds = service.loadData();
			new Watcher(ds);

			logger.info("Welcome to Tax Utility");
			try {    
				while(true) {
				    String dep_location = service.getDepLoc() ;
				    String arr_loc = service.getArrLoc();
				    Date flight_date = service.getFlightDate();
				    String flight_class = service.getFlightClass();
				    String preference = service.getPreference() ;
				    ds.getFlights(dep_location,arr_loc,flight_date,flight_class,preference);
					logger.info("Enter any key to continue or n to exit");
					String choice = input.nextLine();
					if(choice.trim().equals("n")) {
						logger.info("Bye!!! ");
						input.close();
						break;
					}		
				}	
			} catch(Exception e) {
				logger.info(e.getStackTrace());	
			}
			
			
	}

}
