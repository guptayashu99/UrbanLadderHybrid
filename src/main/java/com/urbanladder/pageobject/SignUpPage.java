package com.urbanladder.pageobject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.urbanladder.reusablecomponent.ReusableMethods;
import com.urbanladder.uistore.SignUpPageUI;
import com.urbanladder.utility.Logging;
import com.urbanladder.utility.PropertyFileUtil;

public class SignUpPage {
	
	SignUpPageUI supu= new SignUpPageUI();
	private static Boolean flag = null;
	
	public static boolean getSignUp(WebDriver driver) throws IOException {
		flag = null;
		
		WebElement email =  ReusableMethods.getElement(driver, SignUpPageUI.email);
		WebElement password =  ReusableMethods.getElement(driver, SignUpPageUI.password);
		WebElement signup =  ReusableMethods.getElement(driver, SignUpPageUI.signup);
		
		String username = PropertyFileUtil.loadFile().getProperty("emailid");
		String pass = PropertyFileUtil.loadFile().getProperty("pass");
		try {
			Actions a =new Actions(driver);			
			a.moveToElement(email).click().sendKeys(username).build().perform();			
			a.moveToElement(password).click().sendKeys(pass).build().perform();			
			a.moveToElement(signup).click().build().perform();
			flag = true;
			Logging.log("info", "Sign Up Successfull");
		}
		catch(Exception e) {
			flag = false;
			Logging.log("error", "Could not Sign Up");
		}
		return flag;
	}
	
	public static boolean clickLogin(WebDriver driver) {
		flag = null;
		try {
			ReusableMethods.click(SignUpPageUI.login, driver);
			flag = true;
			Logging.log("info", "Login Button Clicked");
		}
		catch(Exception e) {
			flag = false;
			Logging.log("error", "Could not click on Login");
		}
		return flag;
	}
	

}
