package com.duco.task.taf;

import com.duco.task.taf.data.InputData;
import com.duco.task.taf.data.dataFileManager.YamlDataFileManager;
import com.duco.task.taf.pageObjects.HomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchInGoogleTest extends AbstractTest {

    InputData searchInputData;
    String validShortTextInput;
    String validLongTextInput;
    String emptyTextInput;
    String invalidTextInput;


    @BeforeClass
    public void setupTest(){

       searchInputData = YamlDataFileManager.readDataFromFile("inputData.yaml", InputData.class);

       validShortTextInput = searchInputData.getValidFormatShortInput();
       validLongTextInput = searchInputData.getValidFormatSentence();
       invalidTextInput = searchInputData.getInvalidDataFormat();
       emptyTextInput = "";
    }


    @Test(
            groups = {"UITests", "Smoke", "SearchInGoogle" , "Positive"}
    )
    public void uiSuccessfulHomepageSearchWhenShortTextInputTest(){
        HomePage homePage = new HomePage(driver, wait);
        homePage
                .acceptPromptMessage()
                .setValueForSearchInputField(validShortTextInput)
                .clickSubmitButton()
                .checkIfAnyResultMatches(validShortTextInput);
    }

    @Test(
            groups = {"UITests", "Smoke", "SearchInGoogle", "Positive"}
    )
    public void uiSuccessfulHomepageSearchWhenLongTextInputTest(){
        HomePage homePage = new HomePage(driver, wait);
        homePage
                .acceptPromptMessage()
                .setValueForSearchInputField(validLongTextInput)
                .clickSubmitButton()
                .checkIfAnyResultMatches(validLongTextInput);
    }

    @Test(
            groups = {"UITests", "SearchInGoogle", "Negative"}
    )
    public void uiInvalidHomepageSearchWhenInputFieldEmptyTest(){
        HomePage homePage = new HomePage(driver, wait);
        homePage
                .acceptPromptMessage()
                .setValueForSearchInputField(emptyTextInput)
                .clickSubmitButtonWhenInputFieldEmpty();
    }

    @Test(
            groups = {"UITests", "SearchInGoogle", "Negative"}
    )
    public void uiInvalidHomepageSearchWhenInputFieldHasWrongValueTest(){
        HomePage homePage = new HomePage(driver, wait);
        homePage
                .acceptPromptMessage()
                .setValueForSearchInputField(invalidTextInput)
                .clickSubmitButton()
                .checkIfNoResultMatchesForInvalidSearchValue(invalidTextInput);
    }
}