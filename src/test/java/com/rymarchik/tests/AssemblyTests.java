package com.rymarchik.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.rymarchik.pages.AssemblyPage;
import com.rymarchik.pages.JobPage;
import com.rymarchik.pages.LoginPage;
import com.rymarchik.utils.ConfigProperties;

public class AssemblyTests extends BasicTest {
	
	private LoginPage loginPage = PageFactory.initElements(getWebDriver(), LoginPage.class);
	private JobPage jobPage = PageFactory.initElements(getWebDriver(), JobPage.class);
	private AssemblyPage assemblyPage = PageFactory.initElements(getWebDriver(), AssemblyPage.class);
	
	@Test
	public void assemblyCreationTest() throws Exception {
		jobPage.open();
		if (loginPage.isLoggedOut())
			loginPage.login(admin);
		assemblyPage = jobPage.createAssembly();
		assertTrue(assemblyPage.isAssemblyCreated());
	}
	
	@Test
	public void assemblyEditionTest() throws Exception {
		assemblyPage.open();
		if (loginPage.isLoggedOut())
			loginPage.login(admin);
		assemblyPage.editAssembly();
		assertEquals(assemblyPage.getAssemblyDescription(), ConfigProperties.getProperty("assembly.desc"));
	}
	
	@Test
	public void assemblyRemovalTest() throws Exception {
		assemblyPage.open();
		if (loginPage.isLoggedOut())
			loginPage.login(admin);
		assemblyPage.deleteAssembly();
	}
}
