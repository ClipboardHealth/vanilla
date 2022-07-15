package com.assignment.pages;


import com.assignment.utils.DynamicXpathUtils;
import org.openqa.selenium.By;

import static com.assignment.utils.SeleniumActions.waitAndClick;

public final class MenuComponent {

    private final By btnHamburgerMenu = By.id("nav-hamburger-menu");
    private static final String mainMenuItem = "//div[text()='%s']/parent::a";
    private static final String subMenuItem = "//a[text()='%s']";

    public void clickHambugerMenu()
    {
        waitAndClick(btnHamburgerMenu,"Click on the hamburger menu in the top left corner.");
    }

    public void selectMainMenuSection(String mainMenuItemValue){
        String modifiedXpath = DynamicXpathUtils.getModifiedXpath(mainMenuItem, mainMenuItemValue);
        waitAndClick(By.xpath(modifiedXpath),"Click on the main menu: "+mainMenuItemValue);
    }

    public void selectSubMenuSection(String subMenuItemValue){
        String modifiedXpath = DynamicXpathUtils.getModifiedXpath(subMenuItem, subMenuItemValue);
        waitAndClick(By.xpath(modifiedXpath),"Click on the sub-menu: "+subMenuItemValue);
    }


}
