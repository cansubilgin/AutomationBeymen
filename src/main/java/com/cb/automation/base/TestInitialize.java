package com.cb.automation.base;

import com.cb.automation.config.ConfigReader;
import com.cb.automation.config.Settings;
import com.cb.automation.pages.*;
import io.qameta.allure.Step;
import org.testng.annotations.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;


public class TestInitialize {
    public static boolean TEST_ENABLED = Boolean.FALSE;
    public TestInitialize() {
    }

    @BeforeSuite(alwaysRun = true)
    public void Initialize() throws IOException {
        ConfigReader.readBrowserConfig();
        TEST_ENABLED = Boolean.TRUE;
    }

    @Step("Open the browser")
    @BeforeMethod(alwaysRun = true)
    public void beforeTest() throws MalformedURLException {
        LocalDriverContext.setDriver(FrameworkInitialize.InitializeBrowser());
        LocalDriverContext.getDriver().get(Settings.BaseURL);
        LocalDriverContext.getDriver().manage().window().maximize();
        LocalDriverContext.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
    }

    @Step("Close the browser")
    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        if(LocalDriverContext.getDriver() != null){
            LocalDriverContext.getDriver().quit();
        }
    }
    public SearchPage searchPage(){
        Base base = new Base();
        CurrentPageContext.setCurrentPage(base.GetInstance(SearchPage.class));
        SearchPage searchPage = CurrentPageContext.getCurrentPage().As(SearchPage.class);
        return searchPage;
    }

    public HomePage homePage(){
        Base base = new Base();
        CurrentPageContext.setCurrentPage(base.GetInstance(HomePage.class));
        HomePage homePage = CurrentPageContext.getCurrentPage().As(HomePage.class);
        return homePage;
    }
    public WriteTxt writeTxt(){
        Base base = new Base();
        CurrentPageContext.setCurrentPage(base.GetInstance(WriteTxt.class));
        WriteTxt writeTxt = CurrentPageContext.getCurrentPage().As(WriteTxt.class);
        return writeTxt;
    }
    public BasketPage basketPage(){
        Base base = new Base();
        CurrentPageContext.setCurrentPage(base.GetInstance(BasketPage.class));
        BasketPage basketPage = CurrentPageContext.getCurrentPage().As(BasketPage.class);
        return basketPage;
    }
    public ProductPage productPage(){
        Base base = new Base();
        CurrentPageContext.setCurrentPage(base.GetInstance(ProductPage.class));
        ProductPage productPage = CurrentPageContext.getCurrentPage().As(ProductPage.class);
        return productPage;
    }


}
