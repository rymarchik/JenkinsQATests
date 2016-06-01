package com.rymarchik.tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.rymarchik.pages.LoginPage;

public class LoginLogoutTest extends BasicTest {
	
	private LoginPage loginPage = PageFactory.initElements(getWebDriver(), LoginPage.class);

	@Test
	public void loginLogoutTest() throws Exception {
		loginPage.open();
		loginPage.login(admin);
		assertTrue(loginPage.isLoggedIn());
		loginPage.logout();
		assertTrue(loginPage.isLoggedOut());
	}
}
