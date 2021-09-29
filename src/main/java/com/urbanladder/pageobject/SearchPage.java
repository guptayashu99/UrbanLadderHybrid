package com.urbanladder.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.urbanladder.reusablecomponent.ReusableMethods;
import com.urbanladder.uistore.SearchPageUI;
import com.urbanladder.utility.Logging;
import com.urbanladder.utility.PropertyFileUtil;

public class SearchPage {
	
	ReusableMethods rm = new ReusableMethods();
	private static Boolean flag = null;
	
	public static boolean search(WebDriver driver, String value) {
		flag = null;
		try {
			ReusableMethods.sendKeys(SearchPageUI.search, driver, value);
			System.out.println(value);
			ReusableMethods.click(SearchPageUI.search_Btn, driver);
			System.out.println("Clicked on search button");
			String texts = driver.findElement(SearchPageUI.text).getText();
			texts=texts.toLowerCase();
			System.out.println("text "+texts);
			System.out.println("value "+value);
			if (texts.contains(value.toLowerCase())){
				flag = true;
				Logging.log("info", "Searched for "+value);
			}
		}
		catch(Exception e) {
			flag = false;
			Logging.log("error", "Could not Search for"+value);
		}
		return flag;
	}
	
//	public static boolean getProduct(WebDriver driver) {
//		flag = null;
//		try {
//			ReusableMethods.click(SearchPageUI.product, driver);
//			Logging.log("info", "Clicked on Product");
//			flag= true;
//		}
//		catch(Exception e) {
//			flag = false;
//			Logging.log("error", "Could not click on Product");
//		}
//		return flag;
//	}
	
	public static boolean getProduct(WebDriver driver) {
		flag = null;
		try {
			String productid = PropertyFileUtil.loadFile().getProperty("productid");
			List<WebElement> products = driver.findElements(SearchPageUI.product);
			for(WebElement product: products) {
				String id = product.getAttribute("data-id");
				if(id.equals(productid)) {
					product.click();
					System.out.println(id);
					break;
				}
			}
			flag= true;
		}
		catch(Exception e) {
			flag = false;
			Logging.log("error", "Could not click on Product");
		}
		return flag;
	}
	
	
}
