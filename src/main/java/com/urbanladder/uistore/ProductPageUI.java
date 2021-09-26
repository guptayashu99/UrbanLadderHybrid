package com.urbanladder.uistore;

import org.openqa.selenium.By;

public class ProductPageUI {
	
	public static By productname = By.cssSelector("h1.page-heading.product-title.no-margin");
	
	public static By productprice = By.cssSelector("div.price.final");
	
	public static By pincode = By.cssSelector("span.arrow-icon");
		public static By pincodetxt = By.cssSelector("input.user-pincode");
		public static By pincodecheck = By.cssSelector("button.primary.action-button");
	
	public static By delivery = By.cssSelector("div.delivery-date.text");
		
	public static By addtocart = By.id("add-to-cart-button");

}
