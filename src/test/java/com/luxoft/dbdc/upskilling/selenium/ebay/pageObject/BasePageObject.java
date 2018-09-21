package com.luxoft.dbdc.upskilling.selenium.ebay.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject {

    protected WebDriver webDriver;
    private final int MAX_WAIT_TIME = 10;

    public BasePageObject (WebDriver webDriver){
        this.webDriver = webDriver;
    }

    protected WebElement findElementWithWait(By locator){
        return new WebDriverWait(webDriver, MAX_WAIT_TIME).until(
                ExpectedConditions.visibilityOfElementLocated(locator)
              //  ExpectedConditions.presenceOfAllElementsLocatedBy(locator)

        );
    }
}
