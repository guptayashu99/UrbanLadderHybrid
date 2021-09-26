package com.urbanladder.pageobject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.urbanladder.reusablecomponent.ReusableMethods;
import com.urbanladder.uistore.CheckoutPageUI;
import com.urbanladder.utility.Logging;
import com.urbanladder.utility.PropertyFileUtil;

public class CheckoutPage {
	
	private static Boolean flag = null;
	
	public static boolean getClickCheckout(WebDriver driver) {
		flag = null;
		try {
			ReusableMethods.getElement(driver, CheckoutPageUI.checkout).click();
			Logging.log("info", "Checkout Button Clicked");
			flag = true;
		}
		catch(Exception e) {
			Logging.log("error", "Could not Click on Checkout Button");
			flag = false;
		}
		return flag;
	}
	
	public static boolean getDetails(WebDriver driver) throws IOException {
		flag = null;
		String propemail = PropertyFileUtil.loadFile().getProperty("emailid");
		String proppincode = PropertyFileUtil.loadFile().getProperty("pincode");
		String propaddress = PropertyFileUtil.loadFile().getProperty("address");
		String propfname = PropertyFileUtil.loadFile().getProperty("firstname");
		String proplname = PropertyFileUtil.loadFile().getProperty("lastname");
		String propmobile = PropertyFileUtil.loadFile().getProperty("mobile");
		

		WebElement email = ReusableMethods.getElement(driver, CheckoutPageUI.emailid);
		WebElement pincode = ReusableMethods.getElement(driver, CheckoutPageUI.pincode);
		WebElement address = ReusableMethods.getElement(driver, CheckoutPageUI.address);
		WebElement fname = ReusableMethods.getElement(driver, CheckoutPageUI.firstname);
		WebElement lname = ReusableMethods.getElement(driver, CheckoutPageUI.lastname);
		WebElement mobile = ReusableMethods.getElement(driver, CheckoutPageUI.mobile);
		try {
			Actions a = new Actions(driver);
			email.clear();
			a.moveToElement(email).click().sendKeys(propemail).build().perform();
			pincode.clear();
			a.moveToElement(pincode).click().sendKeys(proppincode).build().perform();
			address.clear();
			a.moveToElement(address).click().sendKeys(propaddress).build().perform();
			Thread.sleep(2000);
			fname.clear();
			a.moveToElement(fname).click().sendKeys(propfname).build().perform();
			lname.clear();
			a.moveToElement(lname).click().sendKeys(proplname).build().perform();
			mobile.clear();
			a.moveToElement(mobile).click().sendKeys(propmobile).build().perform();
			flag = true;
			Logging.log("info", "Details filled on Address Page");
		}
		catch(Exception e) {
			Logging.log("error", "Could not fill details on Address Page");
			flag = false;
		}
		return flag;
	}
	
	public static boolean getSave(WebDriver driver) {
		flag = null;
		try {
			ReusableMethods.getElement(driver, CheckoutPageUI.savecontinue).click();
			flag = true;
			Logging.log("info", "Save and Continue Clicked");
		}
		catch(Exception e) {
			Logging.log("error", "Could not click on Save and Continue");
			flag = false;
		}
		return flag;
	}
	
	public static boolean getHome(WebDriver driver) {
		flag = null;
		try {
			ReusableMethods.click(CheckoutPageUI.homepage, driver);
			flag = true;
			Logging.log("info", "Home Page Clicked on Checkout");
		}
		catch(Exception e) {
			flag = false;
			Logging.log("error", "Could not click on Homepage on Checkout");
			
		}
		return flag;
	}

}
