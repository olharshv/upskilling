package com.luxoft.dbdc.upskilling.selenium;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class SimpleSeleniumTest {

    private static WebDriver webDriver;
    @BeforeAll
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
        ChromeOptions opt = new ChromeOptions();
       //opt.setHeadless(true);
        webDriver = new ChromeDriver();
    }

    @Test
    public void googleSimpleTest() throws InterruptedException {
        String address = "http://www.google.com";
        String queryString = "selenium";
        webDriver.get(address);
      //  WebElement searchField = webDriver.findElement(By.name("q"));
        WebElement searchField = webDriver.findElement(By.xpath("//input[@name='q']"));
        searchField.clear();
        searchField.sendKeys(queryString); //"selenium" + Keys.ENTER
        searchField.submit();
        Thread.sleep(3000);
        //Assertions.assertTrue(()->webDriver.getTitle().equalsIgnoreCase("Google"));
        Assertions.assertTrue(webDriver.getTitle().contains(queryString));
    }

    @AfterAll
    public static void tearDown(){
        webDriver.quit();
    }

}
