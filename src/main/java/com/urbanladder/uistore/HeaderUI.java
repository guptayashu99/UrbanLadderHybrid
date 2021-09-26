package com.urbanladder.uistore;

import org.openqa.selenium.By;

public class HeaderUI {
	
	public static By headerlogo = By.xpath("//figure[@class='header__topBar_logo']");
	
	public static By searchbox = By.xpath("//input[@id='search']");
	
	public static By offerbanner = By.xpath("//a[@href='https://www.urbanladder.com/tnc-jiomart-cashback?src=ticker']");
	
	public static By help = By.xpath("//a[@href='/help']");
	
	public static By trackorder = By.xpath("//a[@href='/orders']");
	
	public static By stores = By.xpath("//a[@href='../../furniture-stores?src=header']");
	
	public static By bulkorders = By.xpath("//a[@href='/buy-in-bulk?src=header']");
	
	public static By giftcards = By.xpath("//a[@href='../../gift-cards?src=header']");
	
	public static By wishlist = By.xpath("//div[@id='shortlist-badge']");
	
	public static By cart = By.xpath("//a[@href='/cart?src=header']");
	
	public static By sale = By.cssSelector("li.topnav_item.saleunit");
	
		public static By dealsofweek = By.xpath("//a[@href='/deals-of-the-week?src=g_topnav_sale_deals-of-the-week']");
		
	public static By living = By.cssSelector("li.topnav_item.livingunit");
	
		public static By sofaset = By.xpath("//a[@href='/sofa-set?src=g_topnav_living_sofa-set']");
	
	public static By bedroom = By.cssSelector("li.topnav_item.bedroomunit");
		
		public static By beds = By.xpath("//a[@href='/bed?src=g_topnav_bedroom_beds']");
	
	public static By dining = By.cssSelector("li.topnav_item.diningunit");
	
	public static By storage = By.cssSelector("li.topnav_item.storageunit");
	
	public static By study = By.cssSelector("li.topnav_item.studyunit");

}
