package com.rymarchik.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.rymarchik.pages.HomePage;
import com.rymarchik.pages.JobPage;
import com.rymarchik.pages.LoginPage;
import com.rymarchik.utils.ConfigProperties;

public class JobTests extends BasicTest {
	
	private LoginPage loginPage = PageFactory.initElements(getWebDriver(), LoginPage.class);
	private HomePage homePage = PageFactory.initElements(getWebDriver(), HomePage.class);
	private JobPage jobPage = PageFactory.initElements(getWebDriver(), JobPage.class);
	
	@Test
	public void jobCreationTest() throws Exception {
		homePage.open();
		if (loginPage.isLoggedOut())
			loginPage.login(admin);
		jobPage = homePage.createJob();
		assertEquals(jobPage.getJobName(), ConfigProperties.getProperty("job.finalname"));
	}
	
	@Test
	public void jobEditionTest() throws Exception {
		jobPage.open();
		if (loginPage.isLoggedOut())
			loginPage.login(admin);
		jobPage.editJob();
		assertEquals(jobPage.getJobDescription(), ConfigProperties.getProperty("job.description"));
	}
	
	@Test
	public void jobTurnOnTurnOffTest() throws Exception {
		jobPage.open();
		if (loginPage.isLoggedOut())
			loginPage.login(admin);
		jobPage.turnJobOnOff();
		assertEquals(jobPage.getButtonText(), ConfigProperties.getProperty("job.button.off"));
		jobPage.turnJobOnOff();
		assertEquals(jobPage.getButtonText(), ConfigProperties.getProperty("job.button.on"));
	}
	
	@Test(dependsOnMethods={"jobTurnOnTurnOffTest"})
	public void jobRemovalTest() throws Exception {
		jobPage.open();
		if (loginPage.isLoggedOut())
			loginPage.login(admin);
		jobPage.deleteJob();
		assertFalse(jobPage.isJobNotDeleted());
	}
}
