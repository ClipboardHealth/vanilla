package com.assignment.pages;

import com.assignment.utils.SeleniumActions;
import org.openqa.selenium.By;

import static com.assignment.utils.SeleniumActions.*;

public final class ProductDescriptionPage {

    private static final By ABOUT_THIS_ITEM_SECTION = By.xpath("//div[@id='feature-bullets']");
    private static final By ABOUT_THIS_ITEM_SECTION_CONTENT = By.xpath("//ul[@class='a-unordered-list a-vertical a-spacing-mini']/li/span");
    public static final By SHOW_MORE_LINK = By.xpath("//span[text()='Show More']");

    private final ProductSummaryComponent productSummaryComponent;

    public ProductDescriptionPage(){
        productSummaryComponent = new ProductSummaryComponent();
    }

    public ProductDescriptionPage switchToNewWindow(){
        SeleniumActions.switchToNewlyOpenedWindow();
        return this;
    }

    public ProductDescriptionPage verifyPresenceOfAboutThisItemSection() {
         verifyPresenceOfElement(ABOUT_THIS_ITEM_SECTION);
         return this;
    }

    public ProductDescriptionPage logAllAboutThisItemSection(){
        logListofElements(ABOUT_THIS_ITEM_SECTION_CONTENT);
        return this;
    }

    public ProductDescriptionPage clickIfShowMoreLinkIsPresent(){
        if(verifyPresenceOfElement(SHOW_MORE_LINK)) {
            waitAndClick(SHOW_MORE_LINK, "Show more link");
        }
        return this;
    }

}
