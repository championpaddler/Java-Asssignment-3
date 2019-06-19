package com.nagarro.assignment3.collection;
import java.util.*;

import org.apache.log4j.Logger;
import com.nagarro.assignment3.dto.*;

public class DataStorage {
     Logger logger = Logger.getLogger(DataStorage.class);
	 ArrayList<Item> finallist = new ArrayList<>();

	public  void setData(Item item ) {

		Boolean found = false;
		for ( Item i : finallist )
	    {
	        if(i.getFlightNo().equals(item.getFlightNo())&&(i.getFlightTime().equals(item.getFlightTime()))) {
	        found= true;
	        break;
	        }
	    }
		if(!found)
		{
			finallist.add(item);
		}

	}
	
	public void updateData(Item item) {
		
		for ( Item i : finallist )
	    {
	        if(i.getFlightNo().equals(item.getFlightNo())&&(i.getFlightTime().equals(item.getFlightTime()))) {
	        i.setfare(item.getfare());
	        i.setClasses(item.getClasses());
	        i.setDuration(item.getDuration());
	        i.setValid(item.getValid());
	        i.setavail(item.getavail());
	        }
	    }
	}
	public  void getFlights(String dep_location, String arr_loc, Date flight_date, String flight_class, String preference) {
		ListIterator<Item>  iterator = finallist.listIterator(); 
		ArrayList<Item> temp1 = new ArrayList<>();

		while (iterator.hasNext()) { 
			Item temp = iterator.next();
			if(temp.isValid(dep_location, arr_loc, flight_date, flight_class)) {
				temp1.add(temp);
			}
        } 
		if(temp1.isEmpty()) {
			logger.info("Sorry for Inconvenience . No Flights Found");	
		}  else {
			if (preference.equals("Fare")) {
				Comparator<Item> c = (s1, s2) -> s1.getfare().compareTo(s2.getfare());
			    temp1.sort(c);
			} else {

				Comparator<Item> c1 = Comparator.comparing((Item p)->p.getDuration()).thenComparing(p->p.getfare());
				temp1.sort(c1);
			}	
			ListIterator<Item>  iterator1 = temp1.listIterator(); 	
			logger.info("FLIGHT_NO  "+"  DURATION "+"PRICE");
			
			if(flight_class.equals("B")) {
				while (iterator1.hasNext()) { 
					Item temp2 = iterator1.next();
					logger.info(temp2.getFlightNo()+"  "+temp2.getDuration()+" "+(temp2.getfare()+0.4*temp2.getfare()));
		        } 
			} else {
				while (iterator1.hasNext()) { 
					Item temp2 = iterator1.next();
					logger.info(temp2.getFlightNo()+"  "+temp2.getDuration()+" "+(temp2.getfare()));
		        } 
				
			}

			
		}
			
			
		}
	}



