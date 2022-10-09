package com.duco.task.taf.pageObjects;

import com.duco.task.taf.pageObjects.interfaces.PageValidationInterface;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class ResultsPage implements PageValidationInterface {

    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBys({
            @FindBy(xpath = "//h3")
    })
    List<WebElement> searchResults;

    @FindBy(css = "//span[text() = 'Grafika']")
    WebElement buttonGraphic;

    @FindBy(xpath = "//span[@aria-current = 'page']/../a")
    WebElement buttonAllResults;

    @FindBy(xpath = "//input[@type='text' and @name='q']")
    WebElement inputSearchFiled;

    @FindBy(css = "p[role='heading']")
    WebElement headingNoResults;

    @FindBy(xpath = "//em[contains(text(),'*.?^@')]")
    WebElement invalidPhrase;

    public ResultsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
        waitForPageLoad();
    }

    @Override
    public void waitForPageLoad() {
        wait.until(ExpectedConditions.visibilityOf(inputSearchFiled));
    }

    public ResultsPage checkIfAnyResultMatches(String expectedValue){

        final String expectedValue1 = expectedValue.toLowerCase();

        Assert.assertTrue(searchResults.stream().anyMatch(re -> re.getText().toLowerCase().contains(expectedValue1)), String.format("Results with value %s not found", expectedValue));
        return this;
    }

    public ResultsPage checkIfNoResultMatchesForInvalidSearchValue(String invalidSearchValue){

        SoftAssert softAssertion= new SoftAssert();
        String invalidPhraseText = invalidPhrase.getText();

        softAssertion.assertTrue(headingNoResults.isDisplayed());
        softAssertion.assertEquals(invalidPhrase.getText(), invalidSearchValue);
        softAssertion.assertAll();

        System.out.println("Podana fraza -  " +invalidPhraseText + "nie została");
        return this;
    }

    public GraphicResults clickGraphicResultButton(){
        buttonGraphic.click();
        return new GraphicResults(driver, wait);
    }
}