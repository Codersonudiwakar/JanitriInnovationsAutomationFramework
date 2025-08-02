package com.Janitri.Innovations.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

	String usrIdInput= "formEmail";
	String passwordInput= "formPassword";
	String loginBtn= "button.login-button";
	String iconBtn= "//div[@class='passowrd-div']/img";
	String subTitle="//p[@class='sub-title']";
	String errMsg="//div[@class='invalid-credential-div']";

	
	
	public void enterUserId(String userId) {
		driver.findElement(By.id(usrIdInput)).sendKeys(userId);
    }

    public void enterPassword(String password) {
    	driver.findElement(By.id(passwordInput)).sendKeys(password);
    }

    public void clickLoginButton() {
    	driver.findElement(By.cssSelector(loginBtn)).click();
    }

    public boolean isLoginButtonEnabled() {
    	return driver.findElement(By.cssSelector(loginBtn)).isEnabled();
    }

    public void clickPasswordEyeIcon() {
        driver.findElement(By.xpath(iconBtn)).click();
    	}

    public boolean isPasswordMasked() {
    return	driver.findElement(By.id(passwordInput)).getAttribute("type").equals("password");
    }

    public boolean isTitlePresent() {
        return driver.getTitle().contains("Janitri");
    }

    public String getErrorMessage() {
        try {
            return driver.findElement(By.xpath(errMsg)).getText();
        } catch (Exception e) {
            return "No Error Message showing";
        }
    }

    public boolean isUserIdFieldDisplayed() {
        return driver.findElement(By.id(usrIdInput)).isDisplayed();
    }

    public boolean isPasswordFieldDisplayed() {
        return driver.findElement(By.id(passwordInput)).isDisplayed();
    }

    public boolean isLoginButtonDisplayed() {
        return driver.findElement(By.cssSelector(loginBtn)).isDisplayed();
    }

    public boolean isEyeIconDisplayed() {
        return driver.findElement(By.xpath(iconBtn)).isDisplayed();
    }
    
    public String getSubTitle() {
    	String txt=driver.findElement(By.xpath(subTitle)).getText();
    	return txt;
    }

	
	
}
