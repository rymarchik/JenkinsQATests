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
	private WebElement fieldJobName;
	
	@FindBy(css = "div.desc")
	private WebElement linkJobType;
	
	@FindBy(id = "ok-button")
	private WebElement buttonJobSubmit;
	
	@FindBy(id = "yui-gen37-button")
	private WebElement buttonJobSave;
	
	
	
	public JobPage createJob() {
		linkCreateJob.click();
		type(fieldJobName, ConfigProperties.getProperty("job.name"));
		linkJobType.click();
		buttonJobSubmit.click();
		buttonJobSave.click();
		return PageFactory.initElements(driver, JobPage.class);
	}
	
	public DomainPage createDomain() {
//		linkCreateJob.click();
//		type(fieldJobName, ConfigProperties.getProperty("job.name"));
//		linkJobType.click();
//		buttonJobSubmit.click();
//		buttonJobSave.click();
		return PageFactory.initElements(driver, DomainPage.class);
	}

	@Override
	public void open() {
		driver.get(ConfigProperties.getProperty("home.url"));
	}
}
