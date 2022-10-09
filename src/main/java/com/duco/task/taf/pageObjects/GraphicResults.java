package com.duco.task.taf.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class GraphicResults {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBys({
            @FindBy(xpath = "//div/h3")
    })
    List<WebElement> graphicResults;

    @FindBy(xpath = "//span[text() = 'Grafika']")
    WebElement buttonGraphic;

    public GraphicResults(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public GraphicResults checkIfAnyGraphicResultMatches(String expectedValue){
        final String expectedValue1 = expectedValue.toLowerCase();

        Assert.assertTrue(graphicResults.stream().anyMatch(re -> re.getText().toLowerCase().contains(expectedValue1)), String.format("Results with value %s not found", expectedValue));
        Assert.assertTrue(buttonGraphic.isSelected());

        return this;
    }
}
