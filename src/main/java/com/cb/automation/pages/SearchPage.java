package com.cb.automation.pages;

import com.cb.automation.base.BasePage;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.qameta.allure.model.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class SearchPage extends BasePage {
    @FindBy(how = How.XPATH, using = "//input[@placeholder='Ürün, Marka Arayın']")
    public WebElement searchArea;
    private final By productName = By.xpath("//*[@class='m-productCard__desc']");
    private final By productPrice = By.xpath("//*[@class='m-productCard__newPrice']");


    public void readcsvAndChooseProduct() {
        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader("C:\\Users\\EXT02D20697\\Desktop\\abd.csv"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        List<String[]> li = null;
        try {
            li = reader.readAll();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (CsvException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Total rows which we have is " + li.size());

        Iterator<String[]> i1 = li.iterator();
        String[] str = i1.next();

        searchArea.sendKeys(str[0]);
        searchArea.click();
        searchArea.sendKeys(Keys.CONTROL, "a");
        searchArea.sendKeys(Keys.BACK_SPACE);
        String[] splitInput = str[1].split(";");
        System.out.println(splitInput[1]);
        searchArea.sendKeys(splitInput[1]);
        searchArea.sendKeys(Keys.ENTER);
        waitFor(3);
        List<WebElement> productNames = presenceOfAllWait(productName, 3);
        List<WebElement> productPrices = presenceOfAllWait(productPrice, 3);
        int max = productNames.size();
        int index = generateRandomInteger(1, max - 1);
        findAndScrollWebElement(productNames.get(index));
        String getProductName = productNames.get(index).getText();
        String getProductPrice = productPrices.get(index).getText();
        WriteTxt.writeText(getProductName, getProductPrice);
        productNames.get(index).click();
    }

}
