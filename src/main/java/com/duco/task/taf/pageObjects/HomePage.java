package com.duco.task.taf.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage{

    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(css = "img[alt=Google]")
    WebElement logoGoogle;

    @FindBy(css = "input[type='text']")
    WebElement inputSearchFiled;

    @FindBy(xpath = "//form/div/div/div[3]/center/input[@type='submit' and @role='button']")
    WebElement buttonSubmit;

    @FindBy(xpath = "//div[contains(text(),'Zaakceptuj wszystko') and @role='none']")
    WebElement buttonAccept;

    @FindBy(xpath = "//form/div/div/div[3]/center/input[@type='submit' and @name='btnI']")
    WebElement buttonFeelingLucky;


    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public HomePage setValueForSearchInputField(String value){
        wait.until(ExpectedConditions.visibilityOf(logoGoogle));
        inputSearchFiled.sendKeys(value);
        return this;
    }

    public HomePage acceptPromptMessage(){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollBy(0,250)", buttonAccept);
        buttonAccept.click();
        return this;
    }

    public ResultsPage clickSubmitButton(){
        buttonSubmit.click();
        return new ResultsPage(driver, wait);
    }

    public WikiPage clickFeelingLuckyButton(){
        buttonFeelingLucky.click();
        return new WikiPage(driver, wait);
    }

    public HomePage clickSubmitButtonWhenInputFieldEmpty(){
        buttonSubmit.click();
        Assert.assertTrue(logoGoogle.isDisplayed(),"Google Home Page is not visible");
        return this;
    }

    public ResultsPage clickFeelingLuckyButtonWhenInputFieldValueIsInvalid(){
        buttonFeelingLucky.click();
        return new ResultsPage(driver, wait);
    }

    public DoodlesPage clickFeelingLuckyButtonWhenInputFieldIsEmpty(){
        buttonFeelingLucky.click();
        return new DoodlesPage(driver, wait);
    }
}