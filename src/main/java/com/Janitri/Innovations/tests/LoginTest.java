package com.Janitri.Innovations.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.Janitri.Innovations.pages.LoginPage;
import com.Janitri.Innovations.utils.BaseTest;
import com.Janitri.Innovations.utils.ScreenshotUtil;

public class LoginTest extends BaseTest {

	@Test
	public void testLoginButtonDisabledWhenFieldAreEmpty() {
		LoginPage lp = new LoginPage(driver);
		ScreenshotUtil.captureScreenshot(driver, "BeforeCheckingLoginButtonDisable");
		ScreenshotUtil.showScreenshotInReport("BeforeCheckingLoginButtonDisable");
		lp.clickLoginButton();
		ScreenshotUtil.captureScreenshot(driver, "AfterClickingLoginButtonWithEmptyFields");
		ScreenshotUtil.showScreenshotInReport("AfterClickingLoginButtonWithEmptyFields");
		Reporter.log("If fields are empty the Login button returning " + lp.isLoginButtonEnabled());
		Assert.assertFalse(lp.isLoginButtonEnabled(), "Login button should be disabled when fields are empty.");
	}

	@Test
	public void testPasswordMaskedbutton() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.enterPassword("12345");
		Thread.sleep(1000);
		ScreenshotUtil.captureScreenshot(driver, "BeforeClickingMaskIcon");
		ScreenshotUtil.showScreenshotInReport("BeforeClickingMaskIcon");
		Assert.assertTrue(lp.isPasswordMasked(), "Password should be masked by default.");
		Reporter.log("Password should be masked by default PASS");
		lp.clickPasswordEyeIcon();
		Thread.sleep(1000);
		ScreenshotUtil.captureScreenshot(driver, "AfterClickingMaskIcon");
		ScreenshotUtil.showScreenshotInReport("AfterClickingMaskIcon");
		Assert.assertFalse(lp.isPasswordMasked(), "Password should be unmasked after clicking eye icon.");
		Reporter.log("Password should be unmasked after clicking eye icon PASS");
	}

	@Test
	public void testInvalidLoginShowErrorMsg() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		driver.navigate().refresh();
		Thread.sleep(1000);
		lp.enterUserId("Sonu");
		Reporter.log("User ID Eneterd");
		Thread.sleep(1000);
		lp.enterPassword("12345");
		Reporter.log("User Password Eneterd");
		Thread.sleep(1000);
		lp.clickLoginButton();
		Reporter.log("Login Button Clicked");
		Thread.sleep(1000);

		String errorMsg = lp.getErrorMessage();
		System.out.println("Error Message: " + errorMsg);
		Assert.assertTrue(errorMsg.contains("Invalid") || errorMsg.length() > 0,
				"Error message should appear for invalid credentials.");
		ScreenshotUtil.captureScreenshot(driver, "invalidLoginError");
		ScreenshotUtil.showScreenshotInReport("invalidLoginError");
	}

	@Test
	public void testElementsPresentOnPage() {
		LoginPage lp = new LoginPage(driver);
		ScreenshotUtil.captureScreenshot(driver, "titileValidate");
		ScreenshotUtil.showScreenshotInReport("titileValidate");
		Assert.assertTrue(lp.isTitlePresent(), "Title should contain 'Janitri'");
		Reporter.log("Title Validatin Pass");
		Assert.assertEquals(lp.getSubTitle(), "Your Pregnancy and Newborn Monitoring Partner");
		Reporter.log("Sub Title Validation pass");
		Assert.assertTrue(lp.isUserIdFieldDisplayed(), "User ID input field should be visible");
		Reporter.log("User ID input Field Validation pass");
		Assert.assertTrue(lp.isPasswordFieldDisplayed(), "Password input field should be visible");
		Reporter.log("User Password input validation pass");
		Assert.assertTrue(lp.isLoginButtonDisplayed(), "Login button should be visible");
		Reporter.log("Login button validation pass");
		Assert.assertTrue(lp.isEyeIconDisplayed(), "Eye icon should be visible");
		Reporter.log("Eye icon visible");
	}

}
