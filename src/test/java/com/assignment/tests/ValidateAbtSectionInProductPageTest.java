package com.assignment.tests;

import com.assignment.facade.NavigateToProductPageFacade;
import com.assignment.pages.ProductDescriptionPage;
import com.assignment.testdata.TestData;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ValidateAbtSectionInProductPageTest extends BaseTest{

    @Test(dataProvider = "getData", description = "To validate ABOUT THE SECTION presence in second highest priced item in Television ")
    public void verifyAbtSectionInSecondHighestTvItem(TestData testData) {
        new NavigateToProductPageFacade().navigateToMenuAndSubMenu(testData.getMainMenu(), testData.getSubMenu())
                .selectFilter(testData.getFilter())
                .selectSortByOptionHighToLow()
                .selectNthLargestItem(testData.getNthLargestNum());

        new ProductDescriptionPage().
                switchToNewWindow().
                clickIfShowMoreLinkIsPresent().
                verifyPresenceOfAboutThisItemSection().
                logAllAboutThisItemSection();
    }

    @DataProvider
    public Object[][] getData(){
        return new Object[][]{
                {
                        TestData.builder()
                                .setMainMenu("TV, Appliances, Electronics")
                                .setSubMenu("Televisions")
                                .setFilter("Samsung")
                                .setNthLargestNum("2")
                                .build()
                }
        };
    }


}
