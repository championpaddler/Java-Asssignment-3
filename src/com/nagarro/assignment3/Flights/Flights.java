package com.nagarro.assignment3.Flights;
import com.nagarro.assignment3.collection.DataStorage;
import com.nagarro.assignment3.constants.TaxConstants;
import com.nagarro.assignment3.services.*;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchService;
import java.text.ParseException;
import java.util.*;
import com.nagarro.assignment3.dto.*;

import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;
/**
* The class helps Calculate Tax on Products 
* And output them
* @version 0.1
* @author Shubham Kumar
*/

public class Flights {


	public static void main(String[] args) throws IOException, InterruptedException{
		    Logger logger = Logger.getLogger(Flights.class);
		    BasicConfigurator.configure();
			Scanner input = new Scanner(System.in);
		    Services service = new Services();
		    DataStorage ds = null;
			try {
				ds= service.loadData();
			} catch (ParseException e1) {
				e1.printStackTrace();
			} 
			logger.info("Welcome to Tax Utility");
			try {
		       

				while(true) {
				    String dep_location = service.getDepLoc() ;
				    String arr_loc = service.getArrLoc();
				    Date flight_date = service.getFlightDate();
				    String flight_class = service.getFlightClass();
				    String preference = service.getPreference() ;
				    ds.getFlights(dep_location,arr_loc,flight_date,flight_class,preference);

//					String type = helper.getType();
//					Integer quantity = helper.getQuantity();
//					Double price = helper.getPrice();
//					Item item = helper.processData(name, type, quantity, price);
//					ds.setData(item);
//					ds.getData();
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
