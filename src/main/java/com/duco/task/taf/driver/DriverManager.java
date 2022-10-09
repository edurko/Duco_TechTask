package com.duco.task.taf.driver;

import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.util.Objects;

public class DriverManager {

    private static WebDriver driver;

    private DriverManager() {
    }

    public static WebDriver getWebDriver(BrowserType browser) throws MalformedURLException {

        if(driver == null) {
            driver = BrowserFactory.getBrowser(browser);
        }
        return driver;
    }

    public static void disposeDriver() {

        if (Objects.nonNull(driver)) {
            try {
                driver.quit();
            } catch (NoSuchSessionException e) {
            } finally {
                driver = null;
            }
        }
    }
}
