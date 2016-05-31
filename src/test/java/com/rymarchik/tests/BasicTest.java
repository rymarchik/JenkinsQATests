package com.rymarchik.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

import com.rymarchik.entities.User;
import com.rymarchik.utils.ConfigProperties;

public class BasicTest {
	
	protected static WebDriver driver;
	
	public User admin = new User(ConfigProperties.getProperty("username"), ConfigProperties.getProperty("password"));
	
	protected WebDriver getWebDriver() {
		if (driver == null) {
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(Long.parseLong(ConfigProperties.getProperty("imp.wait")), TimeUnit.SECONDS);
		}
		return driver;
	}
	
	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
	}
}
