package com.urbanladder.pageobject;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.urbanladder.reusablecomponent.ReusableMethods;
import com.urbanladder.uistore.StorePageUI;
import com.urbanladder.utility.Logging;
import com.urbanladder.utility.PropertyFileUtil;

public class StorePage {
	
	private static Boolean flag = null;
	
	public static boolean getStores(WebDriver driver) throws IOException {
		flag = null;
		String location = PropertyFileUtil.loadFile().getProperty("storelocation");
		try {
			List<WebElement> stores = driver.findElements(StorePageUI.store);
			
			for(WebElement store: stores) {
				String href = store.getAttribute("href");
				System.out.println(href);
				if(href.contains(location)) {
					store.click();
					flag = true;
					Logging.log("info", "Store Found at "+location);
					break;					
				}
				else {
					System.out.println("Location Not Available");
					flag = false;
					
				}
			}
		}
		catch(Exception e) {
			flag = false;
		}
		return flag;
	}
	
	public static boolean getStoreAddress(WebDriver driver) {
		flag = null;
		try {
			String Address = ReusableMethods.getElement(driver, By.cssSelector("address.detail")).getText();
			System.out.println(Address);
			flag = true;
			Logging.log("info", "Store Address Retrieved");
		}
		catch(Exception e) {
			flag = false;
			Logging.log("error", "Could not Retrieve Store Address");
		}
		return flag;
	}

}
