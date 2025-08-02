package com.Janitri.Innovations.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends AfterSetup {
    @BeforeMethod
    public void setup() {
        try {
            ConfigReader.loadConfig();
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--enable-notifications");
            options.addArguments("--start-maximized");
            options.addArguments("--disable-popup-blocking");

            Map<String, Object> prefs = new HashMap<>();
            prefs.put("profile.default_content_setting_values.notifications", 1);
            options.setExperimentalOption("prefs", prefs);

            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

            String url = ConfigReader.getProperty("url");
            System.out.println("Launching URL: " + url);
            driver.get(url);
            WebDriverWait wait = new WebDriverWait(driver, 8);
            try {
                WebElement prompt = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[contains(text(),\"please allow 'Notifications'\")]")));
                try {
                    WebElement reloadBtn = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[normalize-space()='Reload']")));
                    reloadBtn.click();
                } catch (TimeoutException e) {
                    System.out.println("Reload button not found or not clickable.");
                }
            } catch (TimeoutException ignored) {
            }

        } catch (Exception e) {
            System.err.println("Exception during setup(): " + e.getMessage());
            e.printStackTrace();
        }
    }
}
