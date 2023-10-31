package com.EcommerceProject.Utility;

import org.apache.log4j.Logger;

public class Log {
	
	public static Logger log=Logger.getLogger(Log.class.getName());
	
	public static void startTestCase() {
		log.info("Test case is started");
	}
	public static void endTestCase() {
		log.info("Test case is ended");
	}

	public static void info(String message) {
		log.info(message);
	}
	
	
	public static void warn(String message) {
		log.warn(message);
	}
}
