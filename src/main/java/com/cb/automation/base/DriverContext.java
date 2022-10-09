package com.cb.automation.base;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DriverContext {
    public DriverContext() {
    }


    public void waitFor(long second) {
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (Exception e) {
        }
    }

    public void waitUntilFrameToBeAvailableAndSwitchToItByWebelement(WebElement webElement) {
        try {
            WebDriverWait wait = new WebDriverWait(LocalDriverContext.getDriver(), Duration.ofSeconds(30));
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(webElement));
        } catch (Throwable var3) {
            Assert.fail("The frame can not be found according to the expected element: " + webElement + "!");
        }

    }
    public void findAndScrollWebElement(WebElement element) {
        try {
            Actions actions = new Actions(LocalDriverContext.getDriver());
            actions.moveToElement(element).build().perform();
            waitFor(1);
        } catch (Throwable var3) {
            Assert.fail("The element: "+element+" cannot be found! The reason: "+ExceptionUtils.getMessage(var3));
        }

    }
    public void waitForPageToLoad() {
        try {
            WebDriverWait wait = new WebDriverWait(LocalDriverContext.getDriver(), Duration.ofSeconds(30));
            JavascriptExecutor jsExecutor = (JavascriptExecutor) LocalDriverContext.getDriver();
            ExpectedCondition<Boolean> jsLoad = webDriver -> ((JavascriptExecutor) LocalDriverContext.getDriver())
                    .executeScript("return document.readyState").toString().equals("complete");
            boolean jsReady = jsExecutor.executeScript("return document.readyState").toString().equals("complete");
            if (!jsReady)
                wait.until(jsLoad);
            else
                System.out.println("The page is loaded successfully!");
        } catch (Throwable var6) {
            Assert.fail("The page cannot be loaded! The reason: "+ExceptionUtils.getMessage(var6));
        }
    }

    public void switchToDefaultContent() {
        LocalDriverContext.getDriver().switchTo().defaultContent();
    }


    public boolean checkElementIsDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Throwable var3) {
            return false;
        }
    }

    public List<WebElement> presenceOfAllWait(By locator, int seconds) {
        try {
            WebDriverWait wait = new WebDriverWait(LocalDriverContext.getDriver(), Duration.ofSeconds(seconds));
            return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        } catch (Exception ex) {
            Assert.fail("The element: " + locator + " cannot be found! The reason: " + ex.getMessage());
            return null;
        }
    }

    public Integer generateRandomInteger(int min, int max) {
        try {
            int random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);
            return random_int;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void randomNumber(By selector) {
        String generatedString = RandomStringUtils.random(9, false, true);
        LocalDriverContext.getDriver().findElement(selector).sendKeys("5" + generatedString);//1CFP
        System.out.println(generatedString);

    }
}
