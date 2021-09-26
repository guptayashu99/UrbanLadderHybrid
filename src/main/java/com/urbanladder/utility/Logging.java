package com.urbanladder.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logging {
    private static Logger logger = LogManager.getLogger();
    public static void main(String[] args) {
    	log("info", "bla");
    	log("debug", "bla");
    	log("warn", "bla");
    	log("error", "bla");
    	log("fatal", "bla");
    }
    
    public static void log(String type, String message) {
    	if(type.equals("info")) {
            logger.info(message);
    	}
    	
    	else if(type.equals("debug")) {
    		logger.debug(message);
    	}
    	
    	else if(type.equals("warn")) {
    		logger.warn(message);
    	}
    	
    	else if(type.equals("error")) {
    		logger.error(message);
    	}
    	
    	else if(type.equals("fatal")) {
    		logger.fatal(message);
    	}

    }

}