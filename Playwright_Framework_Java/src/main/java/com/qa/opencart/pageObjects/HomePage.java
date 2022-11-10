package com.qa.opencart.pageObjects;

import com.microsoft.playwright.Page;

public class HomePage {

	private Page page;

	// 1. String Locators
	private String searchInput = "input[name='search']";
	private String searchButton = "div#search button";
	private String searchedItemHeader = "div#content h1";
	private String loginLink = "a:text('Login')";
	private String myAccountLink = "a[title='My Account']";
	

	// 2. page constructor:
	public HomePage(Page page) {
		this.page = page;
	}

	// 3. page actions/methods:
	public String getHomePageTitle() {
		return page.title();
	}

	public String getHomePageURL() {
		return page.url();
	}

	public String doSearch(String productName) {
		page.fill(searchInput, productName);
		page.click(searchButton);
		return page.textContent(searchedItemHeader);
	}
	
	public LoginPage navigateToLoginPage() {
		page.click(myAccountLink);
		page.click(loginLink);
		return new LoginPage(page);
	}

}
