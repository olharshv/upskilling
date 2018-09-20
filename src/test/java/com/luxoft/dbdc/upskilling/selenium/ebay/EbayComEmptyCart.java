package com.luxoft.dbdc.upskilling.selenium.ebay;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class EbayComEmptyCart extends EbayBase {


    private final String PRIVACY_POLICY_FORM = ".alert";
    private final String PRIVACY_POLICY_ACCEPT_BUTTON = "button.btn-outline";//"//button[contains(@class,'btn-outline')]";
    private final String SHOPPING_CART_ICON = ".etsy-icon-cart";
    private final String CART = "//*[@id='gh-cart-i']";

    private final String EMPTY_CART = "div.empty-cart";
            //"//span[text()='You don't have any items in your cart.']";

    @Test
    public void shouldHaveEmptyShoppingCartOnFirstVisit() throws InterruptedException {
        String mainPage = "http://www.ebay.com";
        //go to ebay.com page
        webDriver.get(mainPage);
        //go to cart page
        WebElement cartButton = webDriver.findElement(By.xpath(CART));
        cartButton.click();
        //check if card is empty
        WebElement emptyCart = webDriver.findElement(By.cssSelector(EMPTY_CART));
        //webDriver.findElement(By.xpath(EMPTY_CART));
        Assertions.assertTrue(emptyCart.isDisplayed());
        //  webDriver.get(mainPage + "/gh-cart-i");
        Thread.sleep(3000);
    }
}