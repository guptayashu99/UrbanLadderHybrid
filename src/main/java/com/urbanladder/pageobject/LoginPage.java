package com.urbanladder.pageobject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.urbanladder.reusablecomponent.ReusableMethods;
import com.urbanladder.uistore.LoginPageUI;
import com.urbanladder.utility.Logging;
import com.urbanladder.utility.PropertyFileUtil;

public class LoginPage {
	
	LoginPageUI lpu= new LoginPageUI();
	private static Boolean flag = null;
	
	public static boolean getLogin(WebDriver driver) throws IOException {
		flag = null;
		
		WebElement email =  ReusableMethods.getElement(driver, LoginPageUI.email);
		WebElement password =  ReusableMethods.getElement(driver, LoginPageUI.password);
		WebElement login =  ReusableMethods.getElement(driver, LoginPageUI.login);
		
		String username = PropertyFileUtil.loadFile().getProperty("emailid");
		String pass = PropertyFileUtil.loadFile().getProperty("pass");
		try {
			Actions a =new Actions(driver);			
			a.moveToElement(email).click().sendKeys(username).build().perform();			
			a.moveToElement(password).click().sendKeys(pass).build().perform();			
			a.moveToElement(login).click().build().perform();
			flag = true;
			Logging.log("info", "Login Successful");
		}
		catch(Exception e) {
			Logging.log("error", "Could Not Login");
			flag = false;
		}
		return flag;
	}

}
