package com.rymarchik.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.rymarchik.utils.ConfigProperties;

public class JobPage extends Page {

	public JobPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css ="h1.job-index-headline.page-headline")
	private WebElement jobName;
	
	public boolean isJobCreated() {
		return isElementPresent(jobName);
	}
	
	@Override
	public void open() {
		driver.get(ConfigProperties.getProperty("newJob.url"));
	}
}
