package com.assignment.pages;

import com.assignment.utils.DynamicXpathUtils;
import org.openqa.selenium.By;

import static com.assignment.utils.SeleniumActions.selectValueInDropDown;
import static com.assignment.utils.SeleniumActions.waitAndClick;

public final class ProductsDisplayPage {

    private final By drpdwnSort = By.id("s-result-sort-select");
    private static final String DROPDWN_OPTION = "//a[text()='%s']";
    private static final String HIGH_TO_LOW = "Price: High to Low";
    private static final String PRODUCTS_FILTER_CHECKBOX = "//span[text()='%s']";
    private static final String PRICE_NTH_LARGEST = "(//span[@class='a-price-whole'])[%s]";

    public void selectSortByOptionHighToLow(){
        selectValueInDropDown(drpdwnSort, e-> e.selectByVisibleText(HIGH_TO_LOW));
    }

    public void selectBrandFilterOption(String filterOptionValue){
        String modifiedXpath = DynamicXpathUtils.getModifiedXpath(PRODUCTS_FILTER_CHECKBOX, filterOptionValue);
        waitAndClick(By.xpath(modifiedXpath),"Scroll down and filter the results by Brand " +filterOptionValue);
    }

    public void selectNthLargest(String NthLargestValue)
    {
        String modifiedXpath = DynamicXpathUtils.getModifiedXpath(PRICE_NTH_LARGEST, NthLargestValue);
        waitAndClick(By.xpath(modifiedXpath),"Click on the " +NthLargestValue+ " largest price ");
    }
}
