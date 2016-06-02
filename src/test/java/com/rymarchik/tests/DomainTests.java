package com.rymarchik.tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.rymarchik.pages.DomainPage;
import com.rymarchik.pages.HomePage;
import com.rymarchik.pages.LoginPage;
import com.rymarchik.utils.ConfigProperties;

public class DomainTests extends BasicTest {
	
	private LoginPage loginPage = PageFactory.initElements(getWebDriver(), LoginPage.class);
	private HomePage homePage = PageFactory.initElements(getWebDriver(), HomePage.class);
	private DomainPage domainPage = PageFactory.initElements(getWebDriver(), DomainPage.class);
	
	@Test
	public void domainCreationTest() throws Exception {
		homePage.open();
		if (loginPage.isLoggedOut())
			loginPage.login(admin);
		domainPage = homePage.createDomain();
		assertEquals(domainPage.getDomainName(), ConfigProperties.getProperty("domain.name"));
		assertEquals(domainPage.getDomainDescription(), ConfigProperties.getProperty("domain.desc"));
	}
	
    @Test(dependsOnMethods={"domainCreationTest"})
	public void addCredentialsTest() throws Exception {
		domainPage.open();
		if (loginPage.isLoggedOut())
			loginPage.login(admin);
		domainPage.addCredentilas();
		assertEquals(domainPage.getCredentialsDescription(), ConfigProperties.getProperty("credentials.desc"));
	}
	
	@Test(dependsOnMethods={"addCredentialsTest"})
	public void domainEditionTest() throws Exception {
		domainPage.open();
		if (loginPage.isLoggedOut())
			loginPage.login(admin);
		domainPage.editDomain();
		assertEquals(domainPage.getDomainName(), ConfigProperties.getProperty("domain.newname"));
	}
	
	@Test(dependsOnMethods={"domainEditionTest"})
	public void domainRemovalTest() throws Exception {
		domainPage.open(ConfigProperties.getProperty("domain.url") + ConfigProperties.getProperty("domain.newname"));
		if (loginPage.isLoggedOut())
			loginPage.login(admin);
		domainPage.deleteDomain();
	}
}
