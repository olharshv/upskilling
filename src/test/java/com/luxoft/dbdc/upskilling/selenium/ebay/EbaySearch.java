package com.luxoft.dbdc.upskilling.selenium.ebay;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EbaySearch extends EbayBase {
    private final String SEARCH_FIELD = "//*[@id=\"gh-ac\"]";
    private final String SEARCH_BUTTON = "//*[@id=\"gh-btn\"]";
    private final String TAB = "//*[@id=\"cbelm\"]/div[1]/div[2]/span"; //"//span[contains(text(),'Auction')]"

    @Test
    public void findProducts() throws InterruptedException {
        String mainPage = "http://www.ebay.com";
        //go to ebay.com page
        webDriver.get(mainPage);
        //go to search field
        WebElement searchField = webDriver.findElement(By.xpath(SEARCH_FIELD));
        searchField.click();
        //put "leather bags" text
        searchField.sendKeys("leather bags");
        //click Search button
        WebElement searchButton = webDriver.findElement(By.xpath(SEARCH_BUTTON));
        searchButton.click();
      //select Auction items
        WebElement tab = webDriver.findElement(By.xpath(TAB));
        tab.click();
        Thread.sleep(3000);
    }
}
