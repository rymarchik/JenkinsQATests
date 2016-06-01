package com.rymarchik.tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.rymarchik.pages.HomePage;
import com.rymarchik.pages.JobPage;
import com.rymarchik.pages.LoginPage;

public class JobTests extends BasicTest {
	
	private LoginPage loginPage = PageFactory.initElements(getWebDriver(), LoginPage.class);
	private HomePage homePage = PageFactory.initElements(getWebDriver(), HomePage.class);
	private JobPage jobPage;

//	@Test
//	public void jobCreationTest() throws Exception {
//		loginPage.open();
//		homePage = loginPage.login(admin);
//		jobPage = homePage.createJob();
//		assertTrue(jobPage.isJobCreated());
//	}
	@Test
	public void jobCreationTest2() throws Exception {
		homePage.open();
		if (loginPage.isLoggedOut())
			homePage = loginPage.login(admin);
		jobPage = homePage.createJob();
		assertTrue(jobPage.isJobCreated());
	}
	
	@Test
	public void jobEditionTest() throws Exception {
		
	}
	
	@Test
	public void jobRemovalTest() throws Exception {
		
	}
}
