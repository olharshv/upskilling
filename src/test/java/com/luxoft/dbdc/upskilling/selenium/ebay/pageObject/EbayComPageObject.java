package com.luxoft.dbdc.upskilling.selenium.ebay.pageObject;

import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

  /*@FindBy(css=SEARCH_FIELD)
    @FindBy(id="#gh-ac") than getSearchField method is not nessessary*/

public class EbayComPageObject extends BasePageObject{
private static final String SEARCH_FIELD = "#gh-ac";
private final String mainPage = "http://www.ebay.com";
private static String AUCTION_BUTTON = "a[title='Auction']";
private static String  SHOP_BY_PRICE_ITEMS = "div.search-guidance__text-item-title"; //"a.search-guidance__text-item-link"


    public EbayComPageObject(WebDriver webDriver){
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public EbayComPageObject goToMainPage(){
        webDriver.get(mainPage);
        return this;
    }

    public EbayComPageObject searchFor(String item){
        enterSearchCriteriaToSearchField(item);
        return this;
    }

    private void enterSearchCriteriaToSearchField(String item){
        WebElement searchField = getSearchField();
        searchField.clear();
        searchField.sendKeys(item);
        searchField.submit();

    }
    private WebElement getSearchField(){
        return findElementWithWait(By.cssSelector(SEARCH_FIELD));
    }


    public EbayComPageObject selectAuctionItems(){
        selectAuctionItemsOption();
        return this;
    }

    private void selectAuctionItemsOption(){
        findElementWithWait(By.cssSelector(AUCTION_BUTTON)).click();
    }

    public List<String> getAuctionBestPrices(){
        return webDriver.findElements(By.cssSelector(SHOP_BY_PRICE_ITEMS))
                .stream()
                .map(webElement -> webElement.getText())
                .collect(Collectors.toList());
    }
}
