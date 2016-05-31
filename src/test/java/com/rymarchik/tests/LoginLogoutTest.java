package com.rymarchik.tests;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.rymarchik.pages.HomePage;
import com.rymarchik.pages.LoginPage;

public class LoginLogoutTest extends BasicTest {
	
	private LoginPage loginPage = PageFactory.initElements(getWebDriver(), LoginPage.class);
	private HomePage homePage;

	@Test
	public void loginLogoutTest() throws Exception {
		loginPage.open();
		homePage = loginPage.login(admin);
		assertTrue(homePage.isLoggedIn());
		loginPage = homePage.logout();
		assertTrue(loginPage.isLoggedOut());
	}
}
