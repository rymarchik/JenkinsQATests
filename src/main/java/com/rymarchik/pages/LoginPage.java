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
	private WebElement fieldLogin;
	
	@FindBy(name = "j_password")
	private WebElement fieldPassword;
	
	@FindBy(id = "yui-gen1-button")
	private WebElement buttonLogin;
	
	@FindBy(css = "b")
	private WebElement linkLogIn;
	
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

	public void open() {
		driver.get(ConfigProperties.getProperty("login.url"));
	}
}
