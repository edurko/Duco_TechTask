package com.duco.task.taf;

import com.duco.task.taf.data.InputData;
import com.duco.task.taf.data.dataFileManager.YamlDataFileManager;
import com.duco.task.taf.pageObjects.HomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FeelingLuckyGoogleTest extends AbstractTest {

    InputData searchInputData;
    String validShortTextInput;
    String emptyTextInput;
    String invalidTextInput;


    @BeforeClass
    public void setupTest(){

        searchInputData = YamlDataFileManager.readDataFromFile("inputData.yaml", InputData.class);

        validShortTextInput = searchInputData.getValidFormatShortInput();
        invalidTextInput = searchInputData.getInvalidDataFormat();
        emptyTextInput = "";
    }

    @Test(
            groups = {"UITests", "UITests", "Smoke", "FeelingLucky", "Positive"}
    )
    public void uiSuccessfulFeelingLuckyWhenInputFiledHasValueTest(){
        HomePage homePage = new HomePage(driver, wait);
        homePage
                .acceptPromptMessage()
                .setValueForSearchInputField(validShortTextInput)
                .clickFeelingLuckyButton()
                .checkIfFeelingLuckyResultsAreFound(validShortTextInput);
    }

    @Test(
            groups = {"UITests", "Smoke", "FeelingLucky", "Positive"}
    )
    public void uiSuccessFeelingLuckyWhenInputFieldIsEmptyTest(){
        HomePage homePage = new HomePage(driver, wait);
        homePage
                .acceptPromptMessage()
                .setValueForSearchInputField(emptyTextInput)
                .clickFeelingLuckyButtonWhenInputFieldIsEmpty()
                .checkIfDoodlesPageIsVisible();
    }

    @Test(
            groups = {"UITests", "FeelingLucky", "Negative"}
    )
    public void uiInvalidFeelingLuckyWhenInputFieldHasWrongValueFormatTest(){
        HomePage homePage = new HomePage(driver, wait);
        homePage
                .acceptPromptMessage()
                .setValueForSearchInputField(invalidTextInput)
                .clickFeelingLuckyButtonWhenInputFieldValueIsInvalid()
                .checkIfNoResultMatchesForInvalidSearchValue(invalidTextInput);
    }
}
