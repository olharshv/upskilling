package com.luxoft.dbdc.upskilling.selenium.ebay;

import com.luxoft.dbdc.upskilling.selenium.ebay.pageObject.EbayComPageObject;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class EbayComTest {

    protected static WebDriver webDriver;
    EbayComPageObject ebayPage;

    @BeforeAll
    public static void setUp()  {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
        ChromeOptions opt = new ChromeOptions();
        webDriver = new ChromeDriver();
        webDriver.manage().deleteAllCookies();
    }

    @BeforeEach
    public void setUpForEach(){
        ebayPage = new EbayComPageObject(webDriver);
    }

    @Test
    public void shouldShowBestPriceWhenSelectAuctionAfterSearch(){
        ebayPage.goToMainPage()
                .searchFor("leather bags")
                .selectAuctionItems();
        assertThat(ebayPage.getAuctionBestPrices(),
                containsInAnyOrder("Under $8.00", "$8.00 - $18.00", "Over $18.00"));
        }

    @Test
    public void shouldShowBestPriceWhenSelectAuctionAfterSearchAdditionalCategory() throws InterruptedException {
        ebayPage.goToMainPage()
                .selectItemsInAdditionalCategoryForCategory("iPhone", "Electronics");
        Thread.sleep(3000);

    }
    @AfterEach
    public void tearDown(){
        webDriver.quit();
    }
}
