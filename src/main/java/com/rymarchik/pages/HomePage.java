package com.rymarchik.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Page {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//div[@id='header']/div[2]/span/a[2]/b")
	public WebElement linkLogOut;
	
	public boolean isLoggedIn() {
		return isElementPresent(linkLogOut);
	}
	
	public LoginPage logout() {
		linkLogOut.click();
		return PageFactory.initElements(driver, LoginPage.class);
	}

	@Override
	public void open() {

	}
}
