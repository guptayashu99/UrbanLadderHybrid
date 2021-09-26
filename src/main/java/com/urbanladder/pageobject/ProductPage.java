package com.urbanladder.pageobject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.urbanladder.reusablecomponent.ReusableMethods;
import com.urbanladder.uistore.ProductPageUI;
import com.urbanladder.utility.Logging;
import com.urbanladder.utility.PropertyFileUtil;

public class ProductPage {
	
	public static ProductPage pp = new ProductPage();
	public static ReusableMethods rm = new ReusableMethods();
	private static Boolean flag = null;
	
	public static boolean getProductName(WebDriver driver) {
		flag = null;
		try {
			String name = ReusableMethods.getElement(driver, ProductPageUI.productname).getText();
			System.out.println(name);
			flag = true;
			Logging.log("info", "Product Name Retrieved");
		}
		catch(Exception e) {
			flag = false;
			Logging.log("error", "Could not Retrieve Product Name");
		}
		return flag;
	}
	
	public static boolean getPrice(WebDriver driver) {
		flag = null;
		try {
			String price = ReusableMethods.getElement(driver, ProductPageUI.productprice).getText();
			System.out.println(price);
			flag = true;
			Logging.log("info", "Product Price Retrieved");
		}
		catch(Exception e) {
			flag = false;
			Logging.log("error", "Could not Retrieve Product Price");
		}
		return flag;
	}
	
	public static boolean getPincode(WebDriver driver) throws IOException {
		flag = null;
		String pincode = PropertyFileUtil.loadFile().getProperty("pincode");
		try {
			ReusableMethods.getElement(driver, ProductPageUI.pincode).click();
			
			ReusableMethods.getElement(driver, ProductPageUI.pincodetxt).click();
			ReusableMethods.getElement(driver, ProductPageUI.pincodetxt).sendKeys(pincode);
			ReusableMethods.getElement(driver, ProductPageUI.pincodecheck).click();
			flag = true;
			Logging.log("info", "Pincode Changed");
		}
		catch(Exception e) {
			flag = false;
			Logging.log("error", "Could not change Pincode");
		}
		return flag;
	}
	
	public static boolean getDeliveryDate(WebDriver driver) {
		flag = null;
		try {
			String delivery = ReusableMethods.getElement(driver, ProductPageUI.delivery).getText();
			System.out.println(delivery);
			flag = true;
			Logging.log("info", "Delivery date Retrieved");
		}
		catch(Exception e) {
			flag = false;
			Logging.log("error", "Could not retrieve TubeLight");
		}
		return flag;
	}
	
	public static boolean getAddToCart(WebDriver driver) {
		flag = null;
		try {
			ReusableMethods.getElement(driver, ProductPageUI.addtocart).click();
			flag = true;
			Logging.log("info", "Product Added to cart");
		}
		catch(Exception e) {
			flag = false;
			Logging.log("error", "Could not add Product to cart");
		}
		return flag;
	}

}
