package com.cb.automation.pages;

import com.cb.automation.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ProductPage extends BasePage {
    @FindBy(how = How.XPATH, using = "//*[@class='m-price__new']")
    public WebElement productPrice;
    @FindBy(how = How.XPATH, using = "//*[@class=\"m-variation\"]//*[not(contains(@class,\"m-variation__item -disabled\"))][1]")
    public WebElement productSize;
   @FindBy(how = How.XPATH, using = "//*[@class=\"m-addBasketFavorite__basket btn\"]")
    public WebElement addBasketButton;
   @FindBy(how = How.XPATH, using = "//*[@title=\"Sepetim\"]")
    public WebElement basket;

    public String[] addBasket(){
        waitFor(2);
        String getProductPrice=productPrice.getText();
        productSize.click();
        findAndScrollWebElement(addBasketButton);
        addBasketButton.click();
        basket.click();
        return new String[] {getProductPrice};
    }


}
