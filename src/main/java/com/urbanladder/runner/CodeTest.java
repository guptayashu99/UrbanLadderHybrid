package com.urbanladder.runner;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import com.urbanladder.pageobject.Header;
import com.urbanladder.pageobject.SearchPage;
import com.urbanladder.reusablecomponent.ReusableComponents;
import com.urbanladder.reusablecomponent.ReusableMethods;
import com.urbanladder.uistore.HeaderUI;
import com.urbanladder.uistore.SignUpPageUI;

public class CodeTest {
	
	HeaderUI h = new HeaderUI();
	SignUpPageUI s = new SignUpPageUI();
	ReusableMethods rm = new ReusableMethods();
	
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver; 
		
		driver = ReusableComponents.initializeDriver();
		
		ReusableMethods.getURL(driver);

		SearchPage.search(driver, "Sofa");
		
	}

}
