package com.rymarchik.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.rymarchik.utils.ConfigProperties;

public class AssemblyPage extends Page {

	public AssemblyPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "hoverNotification")
	private WebElement creationNotification;
	
	@FindBy(css = "#description > div")
	private WebElement assemblyDescription;
	
	@FindBy(linkText = "Редактировать информацию сборки")
	private WebElement linkEditInfo;
	
	@FindBy(linkText = "Удалить сборку")
	private WebElement linkDeleteAssembly;
	
	@FindBy(name = "displayName")
	private WebElement fieldAssemblyName;
	
	@FindBy(name = "description")
	private WebElement fieldAssemblyDescription;
	
	@FindBy(id = "yui-gen2-button")
	private WebElement buttonInfoSave;
	
	@FindBy(id = "yui-gen1-button")
	private WebElement buttonConfirmDelete;

	public boolean isAssemblyCreated() {
		return isElementPresent(creationNotification);
	}
	
	public String getAssemblyDescription() {
		return assemblyDescription.getText();
	}
	
	public void editAssembly() {
		linkEditInfo.click();
		type(fieldAssemblyName, ConfigProperties.getProperty("assembly.name"));
		type(fieldAssemblyDescription, ConfigProperties.getProperty("assembly.desc"));
		buttonInfoSave.click();
	}
	
	public void deleteAssembly() {
		linkDeleteAssembly.click();
		buttonConfirmDelete.click();
	}

	@Override
	public void open() {
		driver.get(ConfigProperties.getProperty("job.url") + ConfigProperties.getProperty("job.newname") + "/lastBuild");
	}
}
