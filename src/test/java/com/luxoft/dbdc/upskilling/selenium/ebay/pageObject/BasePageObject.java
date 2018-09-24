package com.luxoft.dbdc.upskilling.selenium.ebay.pageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BasePageObject {

    protected WebDriver webDriver;
    private final int MAX_WAIT_TIME = 10;

    public BasePageObject (WebDriver webDriver){
        this.webDriver = webDriver;
    }

    protected WebElement findElementWithWait(By locator){
        try {
            return new WebDriverWait(webDriver, MAX_WAIT_TIME).until(
                    webDriver1 -> webDriver1.findElement(locator)
            );
        } catch (WebDriverException ex){
            captureScreenShot();
        }
            return null;
    }

    private void captureScreenShot() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
        String time = LocalDateTime.now().format(dtf);
        File screenshot1 = new File("target/screenshot"+time+".png");
        File outFile = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(outFile.toPath(), screenshot1.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //old implementation of findElementWithWait
    /*protected WebElement findElementWithWait(By locator){
        return new WebDriverWait(webDriver, MAX_WAIT_TIME).until(
              //  ExpectedConditions.visibilityOfElementLocated(locator)
               ExpectedConditions.presenceOfElementLocated(locator)
        );
    }*/
}
