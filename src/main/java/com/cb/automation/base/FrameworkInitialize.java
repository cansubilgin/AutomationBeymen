package com.cb.automation.base;

import com.cb.automation.config.Settings;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class FrameworkInitialize {

    public FrameworkInitialize() {
    }

    public static WebDriver InitializeBrowser() {
        WebDriver driver = null;
        if (driver == null) {

            switch (Settings.BrowserType) {
                case Chrome:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case Firefox:
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
            }
        }

        LocalDriverContext.setDriver(driver);
        return driver;
    }
}