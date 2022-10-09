package com.cb.automation.pages;

import com.cb.automation.base.BasePage;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.qameta.allure.model.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class HomePage extends BasePage {

    @FindBy(how = How.ID, using = "onetrust-accept-btn-handler")
    public WebElement acceptCookies;
    @FindBy(how = How.XPATH, using = "//*[@class='o-header__logo--img --blue']")
    public WebElement beymenLogo;


    public HomePage() {
    }
    @Step("Go To Product")
    public void goToWidget() {
        try {

            waitForPageToLoad();
            checkElementIsDisplayed(beymenLogo);
            acceptCookies.click();

            Allure.step("Widget buton tiklandi..", Status.PASSED);
            System.out.println("Widget buton tiklandi..");
        } catch (Exception e) {
            System.out.println("Widget buton tiklanamadi..");
            Allure.step("Widget buton tiklanamadi..", Status.FAILED);
            Assert.fail();
        }
    }}
//    } public void sdfsf() throws IOException {
//        File file = new File("D:/data.csv");
//        if(file.exists()){
//            System.out.println("File Exists");
//        }
//        BufferedReader bufRdr;
//        bufRdr = new BufferedReader(new FileReader(file));
//        String line = null;
//
//        while((line = bufRdr.readLine()) != null){
//            StringTokenizer st = new StringTokenizer(line,",");
//            col=0;
//            while (st.hasMoreTokens()){
//                //Following stroing the data of csv
//                numbers[row][col] = st.nextToken();
//                col++;
//            }
//            System.out.println();
//            row++;
//        }
//        bufRdr.close();
//    }

