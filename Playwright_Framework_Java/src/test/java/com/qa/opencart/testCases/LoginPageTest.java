package com.qa.opencart.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.Constants;

public class LoginPageTest extends BaseTest {

	@Test(priority = 1)
	public void loginPageNavigationTest() {
		loginPage = homePage.navigateToLoginPage();
		String actualLoginPageTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actualLoginPageTitle, Constants.LOGIN_PAGE_TITLE);
	}

	@Test(priority = 2)
	public void forgotPwdLinkExistTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}

	@Test(priority = 3)
	public void appLoginTest() {
		String username = prop.getProperty("username").trim();
		String password = prop.getProperty("password").trim();
		Assert.assertTrue(loginPage.doLogin(username, password));
	}

}
