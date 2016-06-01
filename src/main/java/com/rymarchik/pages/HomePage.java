package com.rymarchik.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rymarchik.utils.ConfigProperties;

public class HomePage extends Page {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//div[@id='header']/div[2]/span/a[2]/b")
	private WebElement linkLogOut;
	
	@FindBy(linkText = "Создать Item")
	private WebElement linkCreateJob;

	@FindBy(id = "name")
	private WebElement fieldJobName;
	
	@FindBy(css = "div.desc")
	private WebElement buttonJobType;
	
	@FindBy(id = "ok-button")
	private WebElement buttonJobSubmit;
	
	@FindBy(id = "yui-gen37-button")
	private WebElement buttonJobSave;
	
	public boolean isLoggedIn() {
		return isElementPresent(linkLogOut);
	}
	
	public LoginPage logout() {
		linkLogOut.click();
		return PageFactory.initElements(driver, LoginPage.class);
	}
	
	public JobPage createJob() {
		linkCreateJob.click();
		type(fieldJobName, ConfigProperties.getProperty("job.name"));
		buttonJobType.click();
		buttonJobSubmit.click();
		buttonJobSave.click();
		return PageFactory.initElements(driver, JobPage.class);
	}

	@Override
	public void open() {
		driver.get(ConfigProperties.getProperty("home.url"));
	}
}
