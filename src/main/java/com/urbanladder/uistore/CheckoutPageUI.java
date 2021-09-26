package com.urbanladder.uistore;

import org.openqa.selenium.By;

public class CheckoutPageUI {
	
	//CART
	public static By homepage = By.cssSelector("img.logo-img");
	
	public static By checkout = By.id("checkout-link");
	
	//ADDRESS
	
	public static By emailid = By.xpath("//input[@placeholder='Enter Email']");
	
	public static By pincode = By.xpath("//input[@placeholder='PIN Code']");
	
	public static By address = By.id("order_ship_address_attributes_address1");
	
	public static By firstname = By.xpath("//input[@placeholder='First Name']");
	
	public static By lastname = By.xpath("//input[@placeholder='Last Name']");
	
	public static By mobile = By.xpath("//input[@placeholder='Enter 10 digit mobile number']");
	
	public static By savecontinue = By.id("address-form-submit");
	

}
