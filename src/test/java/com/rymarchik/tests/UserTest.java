package com.rymarchik.tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.rymarchik.pages.LoginPage;
import com.rymarchik.pages.UserPage;
import com.rymarchik.utils.ConfigProperties;

public class UserTest extends BasicTest {

	private LoginPage loginPage = PageFactory.initElements(getWebDriver(), LoginPage.class);
	private UserPage userPage = PageFactory.initElements(getWebDriver(), UserPage.class);
	
	@Test
	public void editUserInfoTest() throws Exception {
		userPage.open();
		if (loginPage.isLoggedOut())
			loginPage.login(admin);
		userPage.editUserInfo();
		assertEquals(userPage.getUserDescription(), ConfigProperties.getProperty("user.desc"));
	}
}
