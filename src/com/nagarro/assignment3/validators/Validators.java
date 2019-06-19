package com.nagarro.assignment3.validators;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Validators {
	public Validators() {
		
	}

	public  Boolean validateName(String name) {
		return !(("").equals(name.trim()));
	}
	
	public  Boolean validateDate(String date) {
		SimpleDateFormat sdfrmt = new SimpleDateFormat("dd-MM-yyyy");
	    sdfrmt.setLenient(false);
	    try
	    {
	        sdfrmt.parse(date); 
	        return true;
	    }
	    catch (ParseException e)
	    {
	        return false;
	    }
	}
	
	public  Boolean validateType(String type) {
	   try {
		   int t= Integer.parseInt(type);
		   return 	(t==1||t==2);
	   }
	   catch (NumberFormatException e) {
		   return false;
	   }
	}
	
	public  Boolean validateInteger(String price) {
		try {
			Integer.parseInt(price);
			return true;
		}
		catch (NumberFormatException e) {
			   return false;
		}
	}
	
	public  Boolean validateDouble(String price) {
		try {
			Double.parseDouble(price);
			return true;
		}
		catch (NumberFormatException e) {
			   return false;
		}
	}


}
