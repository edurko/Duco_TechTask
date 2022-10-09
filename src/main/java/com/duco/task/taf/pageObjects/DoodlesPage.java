package com.duco.task.taf.pageObjects;

import com.duco.task.taf.pageObjects.interfaces.PageValidationInterface;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DoodlesPage implements PageValidationInterface {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css = "#archive-link-link")
    WebElement linkDoodlesArchive;

    @FindBy(css = "#logo")
    WebElement logoDoodlesGoogle;

    public DoodlesPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
        waitForPageLoad();
    }

    @Override
    public void waitForPageLoad() {
        wait.until(ExpectedConditions.visibilityOf(linkDoodlesArchive));
    }

    public DoodlesPage checkIfDoodlesPageIsVisible(){
        Assert.assertTrue(logoDoodlesGoogle.isDisplayed());
        return this;
    }
}
