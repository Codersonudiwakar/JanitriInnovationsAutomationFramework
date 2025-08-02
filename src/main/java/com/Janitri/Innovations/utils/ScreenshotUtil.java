package com.Janitri.Innovations.utils;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.apache.commons.io.FileUtils;

public class ScreenshotUtil {

    public static String captureScreenshot(WebDriver driver, String imageName) {
        String screenshotDir = System.getProperty("user.dir") + "/Screenshots/";
        String screenshotPath = screenshotDir + imageName+".png";

        try {
            File folder = new File(screenshotDir);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File(screenshotPath);
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return screenshotPath;
    }
    
    public static void showScreenshotInReport(String title) {
        String screenshotDir = System.getProperty("user.dir") + "/Screenshots/";
        String screenshotPath = screenshotDir + title+".png";

        Reporter.log("<br><b><font color='blue'>" + title + ":</font></b><br>");
        Reporter.log("<a href='file://" + screenshotPath + "' target='_blank'>"
                + "<img src='file://" + screenshotPath + "' height='100' width='100'/></a><br>");
    }
}

