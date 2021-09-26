package com.urbanladder.uistore;

import org.openqa.selenium.By;

public class SearchPageUI {
	
	public static By inStock = By.xpath("//input[@id=\"filters_availability_In_Stock_Only\"]");
	
	public static By search = By.id("search");
	
	public static By search_Btn = By.id("search_button");
	
	public static By verifysearch = By.xpath("//h2[@class='withsubtext']");
	
	public static By text = By.xpath("//h2[@class='withsubtext']");
	
	//Product
	
	public static By product = By.cssSelector("a.product-img");

}
