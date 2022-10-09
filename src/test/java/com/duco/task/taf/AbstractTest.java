package com.duco.task.taf;

import com.duco.task.taf.driver.DriverManager;
import com.duco.task.taf.data.ConfigData;
import com.duco.task.taf.driver.BrowserType;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

abstract public class AbstractTest {
    protected final static ConfigData configData = ConfigFactory.create(ConfigData.class);

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setup() throws MalformedURLException{
        driver = DriverManager.getWebDriver(BrowserType.valueOf(configData.driverType()));
        driver.get(configData.uiUrl());
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, configData.waitTimeoutInMinutes());
    }

    @AfterMethod
    public void teardown(){
        DriverManager.disposeDriver();
    }
}