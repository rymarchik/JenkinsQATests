package com.rymarchik.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
	
	@FindBy(css = "td")
	private WebElement textLogin;
	
	@FindBy(xpath = "//div[@id='header']/div[2]/span/a[2]/b")
	private WebElement linkLogOut;
	
	public boolean isLoggedOut() {
		return isElementPresent(fieldLogin);
	}
	
	public boolean isLoggedIn() {
		return isElementPresent(linkLogOut);
	}

	public void login(User admin) {
		type(fieldLogin, admin.getLogin());
		type(fieldPassword, admin.getPassword());
		buttonLogin.click();
	}
	
	public void logout() {
		linkLogOut.click();
	}

	public void open() {
		driver.get(ConfigProperties.getProperty("login.url"));
	}
}
