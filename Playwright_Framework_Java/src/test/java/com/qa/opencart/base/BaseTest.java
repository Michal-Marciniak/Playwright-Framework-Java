package com.qa.opencart.base;

import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.microsoft.playwright.Page;
import com.qa.opencart.factory.PlaywrightFactory;
import com.qa.opencart.pageObjects.HomePage;
import com.qa.opencart.pageObjects.LoginPage;

public class BaseTest {

	private PlaywrightFactory playwrightFactory;
	private Page page;
	protected Properties prop;
	protected HomePage homePage;
	protected LoginPage loginPage;

	//@Parameters({ "browser" })
	@BeforeTest
	public void setup() {

		playwrightFactory = new PlaywrightFactory();
		prop = playwrightFactory.init_prop();

//		if (browserName != null) {
//			prop.setProperty("browser", browserName);
//		}

		page = playwrightFactory.initBrowser(prop);
		homePage = new HomePage(page);
	}

	@AfterTest
	public void tearDown() {
		page.context().browser().close();
	}

}
