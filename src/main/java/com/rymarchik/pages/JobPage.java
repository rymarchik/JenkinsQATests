package com.rymarchik.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rymarchik.utils.ConfigProperties;

public class JobPage extends Page {

	public JobPage(WebDriver driver) {
		super(driver);
	}
    
	@FindBy(css ="h1.job-index-headline.page-headline")
	private WebElement jobName;
	
	@FindBy(css = "#description > div")
	private WebElement jobDescription;
	
	@FindBy(linkText = "Настройки")
	private WebElement linkSettings;
	
	@FindBy(linkText = "Удалить Проект")
	private WebElement linkDelete;
	
	@FindBy(name = "description")
	private WebElement fieldJobDescription;
	
	//delete old assemblies option
	@FindBy(id = "cb7")
	private WebElement option1;
	
	@FindBy(name = "_.numToKeepStr")
	private WebElement fieldOption1;
	
	//build when a change is pushed to GitHub option
	@FindBy(id = "cb19")
	private WebElement option2;
	
	@FindBy(id = "yui-gen37-button")
	private WebElement buttonJobSave;
	
	@FindBy(linkText = "Собрать сейчас")
	private WebElement linkCreateAssembly;
	
	
	@FindBy(id = "yui-gen1-button")
	private WebElement buttonTurnOnOff;
	
	public String getJobName() {
		return jobName.getText();
	}
	
	public String getJobDescription() {
		return jobDescription.getText();
	}
	
	public String getButtonText() {
		return buttonTurnOnOff.getText();
	}
	
	public void turnJobOnOff() {
		buttonTurnOnOff.click();
	}
	
	public boolean isJobNotDeleted() {
		return isElementPresent(jobName);
		
	}
	
	public void editJob() {
		linkSettings.click();
		type(fieldJobDescription, ConfigProperties.getProperty("job.description"));
		option1.click();
		type(fieldOption1, ConfigProperties.getProperty("job.option1"));
		option2.click();
		buttonJobSave.click();
	}
	
	public void deleteJob() {
		linkDelete.click();
		Alert alert = driver.switchTo().alert();
	    alert.accept();
	}
	
	public AssemblyPage createAssembly() {
		linkCreateAssembly.click();
		return PageFactory.initElements(driver, AssemblyPage.class);
	}
	
	@Override
	public void open() {
		driver.get(ConfigProperties.getProperty("job.url") + ConfigProperties.getProperty("job.name"));
	}
}
