package com.urbanladder.uistore;

import org.openqa.selenium.By;

public class SignUpPageUI {
	
	public static By email = By.xpath("//input[@placeholder='Email Address*']");
	
	public static By password = By.xpath("//input[@placeholder='Password*'][2]");
	
	public static By signup = By.xpath("//input[@value='Sign Up']");
	
	public static By login = By.cssSelector("a.login-link.link-color");

}
