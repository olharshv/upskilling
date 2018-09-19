package com.luxoft.dbdc.upskilling.selenium.etsy;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class EtsyComEmptyCard extends EtsyBase {

    private final String PRIVACY_POLICY_FORM = ".alert";
    private final String PRIVACY_POLICY_ACCEPT_BUTTON = "button.btn-outline";//"//button[contains(@class,'btn-outline')]";
    private final String SHOPPING_CART_ICON = ".etsy-icon-cart";
    private final String PRIVACY_POLICY_SUCCESS_MODAL = ".alert-success";
    private final String EMPTY_CART_HEADER = "div.empty-header";


    @Test
    public void shouldHaveEmptyShoppingCartOnFirstVisit() throws InterruptedException {
        String mainPage = "http://www.etsy.com";
        //go to etsy.com page
        webDriver.get(mainPage);
        //accept privacy rule

        //WebElement acceptPrivacyRulesButton = webDriver.findElement(By.cssSelector(PRIVACY_POLICY_FORM))
        //        .findElement(By.xpath(PRIVACY_POLICY_ACCEPT_BUTTON));
        //acceptPrivacyRulesButton.click();
        //go to cart page
        //webDriver.findElement(By.cssSelector(SHOPPING_CART_ICON)).click();
        //new WebDriverWait(webDriver, 20).until(
        //        webDriver1 -> webDriver1.findElement(By.cssSelector(PRIVACY_POLICY_SUCCESS_MODAL)));
        webDriver.get(mainPage + "/cart");
        //check if card is empty
        Thread.sleep(3000);
        boolean isEmptyCart = webDriver.findElement(By.cssSelector(EMPTY_CART_HEADER)).isDisplayed();
        assertThat(isEmptyCart, is(true));

    }
}
