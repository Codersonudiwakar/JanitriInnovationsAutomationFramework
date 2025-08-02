package com.Janitri.Innovations.utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

public class AfterSetup {
	protected WebDriver driver;

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Driver closed successfully.");
        }
    }
    
    @AfterSuite
    public void generateReport() {
        ReportGenerator.copyTestNGReport();
    }


}
