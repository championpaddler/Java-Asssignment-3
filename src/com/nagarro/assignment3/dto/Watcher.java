package com.nagarro.assignment3.dto;

import java.nio.file.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.nagarro.assignment3.collection.DataStorage;
import com.nagarro.assignment3.constants.*;

public class Watcher  {
	public Watcher (DataStorage ds) throws IOException {
	     Thread r = new Thread() {
	         public void run() {

	        	WatchService watchService;
				try {
					watchService = FileSystems.getDefault().newWatchService();

		     		Path directory = Paths.get(TaxConstants.DIRECTORY_TO_WATCH);
		     		WatchKey watchKey = directory.register(watchService, 
		     				StandardWatchEventKinds.ENTRY_MODIFY
		     				);		     	

		     		while (true) {

		     			for (WatchEvent<?> event : watchKey.pollEvents()) {
		     					
		     					Path file = directory.resolve((Path) event.context());
			     				String cvsSplitBy = "\\|"; 

			    			    String csvFile = file.toString();
			    			    String line = "";
			    			    File check = new File(csvFile);					    			    
			    				  try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			    					  	br.readLine();

			    			            while ((line = br.readLine()) != null) {

			    			               String[]  data = line.split(cvsSplitBy);
			    			       
			    							Date date;
											
											date = new SimpleDateFormat("dd-MM-yyyy").parse(data[3]);
											Item item = new Item(data[0],data[1],data[2],date, Integer.parseInt(data[4]),Double.parseDouble(data[5]),Double.parseDouble(data[6]),data[7],data[8]);
				    						ds.updateData(item);
											
			    							
			    			            }
			    			            
			    			        } catch (IOException | ParseException e) {
			    			            e.printStackTrace();
			    			        }
		     				}
		     		
		     			
		     		}
				} catch (IOException e) {
					e.printStackTrace();
				}      
	         }
	     };
	     new Thread(r).start();
	     
	}

     
}
