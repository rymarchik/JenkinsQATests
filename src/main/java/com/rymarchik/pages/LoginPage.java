package com.rymarchik.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rymarchik.entities.User;
import com.rymarchik.utils.ConfigProperties;

public class LoginPage extends Page {
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "j_username")
	public WebElement fieldLogin;
	
	@FindBy(name = "j_password")
	public WebElement fieldPassword;
	
	@FindBy(id = "yui-gen1-button")
	public WebElement buttonLogin;
	
	@FindBy(css = "b")
	public WebElement linkLogIn;
	
	public boolean isLoggedOut() {
		return isElementPresent(linkLogIn);
	}

	public HomePage login(User admin) {
		linkLogIn.click();
		type(fieldLogin, admin.getLogin());
		type(fieldPassword, admin.getPassword());
		buttonLogin.click();
		return PageFactory.initElements(driver, HomePage.class);
	}
	
	@Override
	public void open() {
		driver.get(ConfigProperties.getProperty("login.url"));
	}
}
