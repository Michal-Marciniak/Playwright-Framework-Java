package com.qa.opencart.pageObjects;

import com.microsoft.playwright.Page;

public class LoginPage {

	private Page page;

	// 1. String Locators
	private String emailInput = "//input[@id='input-email']";
	private String passwordInput = "//input[@id='input-password']";
	private String loginButton = "//input[@value='Login']";
	private String forgotPwdLink = "//div[@class='form-group']//a[normalize-space()='Forgotten Password']";
	private String logoutLink = "//a[@class='list-group-item'][normalize-space()='Logout']";

	// 2. page constructor:
	public LoginPage(Page page) {
		this.page = page;
	}
	
	// 3. page actions/methods:
	public String getLoginPageTitle() {
		return page.title();
	}
	
	public boolean isForgotPwdLinkExist() {
		return page.isVisible(forgotPwdLink);
	}
	
	public boolean doLogin(String username, String password) {
		page.fill(emailInput, username);
		page.fill(passwordInput, password);
		page.click(loginButton);
		page.locator(logoutLink).waitFor();
		if(page.locator(logoutLink).isVisible()) {
			return true;
		}else {
			return false;
		}
	}
}
