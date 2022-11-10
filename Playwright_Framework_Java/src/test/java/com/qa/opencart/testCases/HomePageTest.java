package com.qa.opencart.testCases;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.Constants;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

	@Test
	public void homePageTitleTest() {
		String actualTitle = homePage.getHomePageTitle();
		Assert.assertEquals(actualTitle, Constants.HOME_PAGE_TITLE);
	}

	@Test
	public void homePageURLTest() {
		String actualUrl = homePage.getHomePageURL();
		Assert.assertEquals(actualUrl, prop.getProperty("baseUrl"));
	}

	@Test(dataProvider = "getProductData")
	public void searchingProductsTest(String productName) {
		String actualSearchHeader = homePage.doSearch(productName);
		Assert.assertEquals(actualSearchHeader, "Search - " + productName);
	}

	@DataProvider
	public Object[][] getProductData() {
		return new Object[][] {
				{ "Macbook" },
				{ "iMac" },
				{ "Samsung" }
		};
	}

}
