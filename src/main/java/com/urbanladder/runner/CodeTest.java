package com.urbanladder.runner;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.urbanladder.pageobject.ProductPage;
import com.urbanladder.reusablecomponent.ReusableComponents;
import com.urbanladder.reusablecomponent.ReusableMethods;
import com.urbanladder.uistore.SearchPageUI;
import com.urbanladder.utility.PropertyFileUtil;

public class CodeTest {
	
public static void main(String[] args) throws IOException {
	WebDriver driver = ReusableComponents.initializeDriver();
	ReusableMethods.getURL(driver);
	String value = "Sofa";
	String productid = PropertyFileUtil.loadFile().getProperty("productid");
	ReusableMethods.sendKeys(SearchPageUI.search, driver, value);
	System.out.println(value);
	ReusableMethods.click(SearchPageUI.search_Btn, driver);
	System.out.println("Clicked on search button");
	
	List<WebElement> products = driver.findElements(SearchPageUI.product);
	for(WebElement product: products) {
		String id = product.getAttribute("data-id");
		if(id.equals(productid)) {
			product.click();
			System.out.println(id);
			break;
		}
	}
	
	ProductPage.getProductName(driver);
	ProductPage.getPrice(driver);
	ProductPage.getPincode(driver);
	ProductPage.getDeliveryDate(driver);
	ProductPage.getAddToCart(driver);
}

}
