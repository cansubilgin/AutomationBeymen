package com.cb.automation.pages;

import com.cb.automation.base.BasePage;
import com.cb.automation.base.TestInitialize;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class BasketPage extends BasePage {

    private final String emptyText = "SEPETINIZDE ÜRÜN BULUNMAMAKTADIR";
    @FindBy(how = How.XPATH, using = "//*[@class='m-productPrice__salePrice']")
    public WebElement basketProductPrice;
    @FindBy(how = How.XPATH, using = "//*[@class=\"m-variation\"]//*[not(contains(@class,\"m-variation__item -disabled\"))][1]")
    public WebElement productSize;
   @FindBy(how = How.XPATH, using = "//*[@class=\"m-addBasketFavorite__basket btn\"]")
    public WebElement addBasketButton;
   @FindBy(how = How.XPATH, using = "//*[@title=\"Sepetim\"]")
    public WebElement basket;
   @FindBy(how = How.ID, using = "quantitySelect0-key-0")
    public WebElement piece;
   @FindBy(how = How.XPATH, using = "//*[@id=\"removeCartItemBtn0-key-0\"]")
    public WebElement delete;
   @FindBy(how = How.XPATH, using = "//*[text()=\"Sepetinizde Ürün Bulunmamaktadır\"]")
    public WebElement emptyBasketText;

    public void verifyBasket(String getProductPrice){
        waitFor(3);
      String getBasketProductPrice= basketProductPrice.getText();

        if (!getBasketProductPrice.equals(getProductPrice)) {
            System.out.println("Random secilen ürün" + getBasketProductPrice + "ile detayli ürün" + getProductPrice + " ayni degil..");

        } else {
            System.out.println("Random secilen ürün" + getBasketProductPrice + "ile detayli ürün" + getProductPrice + " ayni..");

        }

    }

    public void addCount(){
        waitFor(3);
//        piece.click();
        piece.sendKeys("2");
        waitFor(4);

    }
    public void deleteProduct(){
        waitFor(3);
        delete.click();
        waitFor(5);
        String getEmptyBasketText = emptyBasketText.getText();
        System.out.println(getEmptyBasketText);
        if (!getEmptyBasketText.equals(emptyText)) {
            Assert.fail("Sepetteki ürün silinemedi");
        }
        System.out.println("Sepetteki ürün silindi..");


    }


}
