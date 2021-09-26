package com.urbanladder.utility;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OpenReport {

	
	public static void main(String[] args) {
		openReport();
	}
	
	
	public static File openReport() {
		
		String out = new SimpleDateFormat("yyyy-MM-dd hh-mm").format(new Date());
		System.out.println(out);

		File files = new File(".\\ExtentReports");
		File actfile = null;
		for(File file:files.listFiles()) {
			if(file.getName().contains(out)){
				System.out.println(file.getName());
				actfile = file;
				break;
			}
		}
		return actfile;
		
	}

}
