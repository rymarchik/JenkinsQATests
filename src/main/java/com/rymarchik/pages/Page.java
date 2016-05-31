package com.rymarchik.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class Page {
	
	protected WebDriver driver;
	
	public Page(WebDriver driver) {
		this.driver = driver;
	}
	
	public abstract void open();
	
	protected void type(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}
	
	public boolean isElementPresent(WebElement element) {
		try {
			element.isDisplayed();
			return true;
		}
		catch (NoSuchElementException e) {
			return false;
		}
	}
}
