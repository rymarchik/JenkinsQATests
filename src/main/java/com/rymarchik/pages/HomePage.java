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
	
	@FindBy(linkText = "Создать Item")
	private WebElement linkCreateJob;

	@FindBy(id = "name")
	private WebElement fieldName;
	
	@FindBy(css = "div.desc")
	private WebElement linkJobType;
	
	@FindBy(id = "ok-button")
	private WebElement buttonSubmit;
	
	@FindBy(id = "yui-gen37-button")
	private WebElement buttonJobSave;
	
	
	@FindBy(linkText = "Credentials")
	private WebElement linkCredentials;
	
	@FindBy(linkText = "System")
	private WebElement linkSystem;
	
	@FindBy(linkText = "Add domain")
	private WebElement linkCreateDomain;
	
	@FindBy(name = "description")
	private WebElement fieldDescription;
	
	
	public JobPage createJob() {
		linkCreateJob.click();
		type(fieldName, ConfigProperties.getProperty("job.name"));
		linkJobType.click();
		buttonSubmit.click();
		buttonJobSave.click();
		return PageFactory.initElements(driver, JobPage.class);
	}
	
	public DomainPage createDomain() {
		linkCredentials.click();
		linkSystem.click();
		linkCreateDomain.click();
		type(fieldName, ConfigProperties.getProperty("domain.name"));
		type(fieldDescription, ConfigProperties.getProperty("domain.desc"));
		buttonSubmit.click();
		return PageFactory.initElements(driver, DomainPage.class);
	}

	@Override
	public void open() {
		driver.get(ConfigProperties.getProperty("home.url"));
	}
}
