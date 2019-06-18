package com.nagarro.assignment3.notifications;

import org.apache.log4j.Logger;


public class Notifications {
	
    Logger logger = Logger.getLogger(Notifications.class);

	public  void invalidClass() {
		logger.info("Invalid Class . Enter :");
		logger.info("Enter 1 for Economy");
		logger.info("Enter 2 for Business");
    }
	
	public  void invalidFilter() {
		logger.info("Invalid Class . Enter :");
		logger.info("Enter 1 for Fare");
		logger.info("Enter 2 for Both Fare And Time");
    }
	

}
