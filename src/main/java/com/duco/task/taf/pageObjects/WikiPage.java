package com.duco.task.taf.pageObjects;

import com.duco.task.taf.pageObjects.interfaces.PageValidationInterface;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WikiPage implements PageValidationInterface {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(xpath = "//h1/span[@class='mw-page-title-main']")
    WebElement headerResult;

    @FindBy(css = "a[class='mw-wiki-logo']")
    WebElement logoWiki;

    public WikiPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
        waitForPageLoad();
    }

    @Override
    public void waitForPageLoad() {
        wait.until(ExpectedConditions.visibilityOf(logoWiki));
    }

    public WikiPage checkIfFeelingLuckyResultsAreFound(String expectedValue){
        expectedValue = expectedValue.toLowerCase();
        String actualResults = headerResult.getText().toLowerCase();

        Assert.assertTrue(actualResults.contains(expectedValue));
        return this;
    }
}