package com.rymarchik.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.rymarchik.utils.ConfigProperties;

public class DomainPage extends Page {

	public DomainPage(WebDriver driver) {
		super(driver);
	}
    
	@FindBy(css = "h1")
	private WebElement domainName;
	
	@FindBy(css = "#main-panel > div")
	private WebElement domainDesc;
	
	
	@FindBy(linkText = "Configure")
	private WebElement linkEditDomain;
	
	@FindBy(id = "name")
	private WebElement fieldDomainName;
	
	@FindBy(id = "save-button")
	private WebElement buttonSaveDomain;
	
	@FindBy(linkText = "Delete domain")
	private WebElement linkDeleteDomain;
	
	@FindBy(id = "yui-gen1-button")
	private WebElement buttonConfirmDelete;

	
	@FindBy(linkText = "Add Credentials")
	private WebElement linkAddCredentials;
	
	@FindBy(name = "_.username")
	private WebElement fieldName;
	
	@FindBy(name = "_.password")
	private WebElement fieldPassword;
	
	@FindBy(name = "_.id")
	private WebElement fieldId;
	
	@FindBy(name = "_.description")
	private WebElement fieldDescription;
	
	@FindBy(xpath = "//div[@id='main-panel']/table/tbody/tr[2]/td[4]")
	private WebElement credentialsDesc;
	
	
	public String getDomainName() {
		return domainName.getText();
	}
	
	public String getDomainDescription() {
		return domainDesc.getText();
	}
	
	public String getCredentialsDescription() {
		return credentialsDesc.getText();
	}

	public void addCredentilas() {
		linkAddCredentials.click();
		type(fieldName, ConfigProperties.getProperty("username"));
		type(fieldPassword, ConfigProperties.getProperty("password"));
		type(fieldId, ConfigProperties.getProperty("credentials.id"));
		type(fieldDescription, ConfigProperties.getProperty("credentials.desc"));
		buttonConfirmDelete.click();
	}
	
	public void editDomain() {
		linkEditDomain.click();
		type(fieldDomainName, ConfigProperties.getProperty("domain.newname"));
		buttonSaveDomain.click();
	}
	
	public void deleteDomain() {
		linkDeleteDomain.click();
		buttonConfirmDelete.click();
	}
	
	@Override
	public void open() {
		driver.get(ConfigProperties.getProperty("domain.url") + ConfigProperties.getProperty("domain.name"));
	}
}
