package com.rymarchik.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.rymarchik.utils.ConfigProperties;

public class UserPage extends Page {

	public UserPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(linkText = "Настроить")
	private WebElement linkEditInfo;
	
	@FindBy(name = "_.description")
	private WebElement fieldUserDescription;
	
	@FindBy(name = "user.password")
	private WebElement fieldChangePassword;
	
	@FindBy(name = "user.password2")
	private WebElement fieldConfirmPassword;
	
	@FindBy(id = "yui-gen3-button")
	private WebElement buttonSave;
	
	@FindBy(css = "#description > div")
	private WebElement userDescription;
	
	public String getUserDescription() {
		return userDescription.getText();
	}
	
	public void editUserInfo() {
		linkEditInfo.click();
		type(fieldUserDescription, ConfigProperties.getProperty("user.desc"));
		type(fieldChangePassword, ConfigProperties.getProperty("user.pass"));
		type(fieldConfirmPassword, ConfigProperties.getProperty("user.pass"));
		buttonSave.click();
	}
	
	@Override
	public void open() {
		driver.get(ConfigProperties.getProperty("user.url"));
	}
}
