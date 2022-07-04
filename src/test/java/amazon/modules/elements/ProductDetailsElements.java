package amazon.modules.elements;

import amazon.utils.PropertyUtil;
import org.openqa.selenium.By;

public class ProductDetailsElements {

    private static By ABOUT_ITEM_SECTION  = null;
    private static By ABOUT_ITEM_SECTION_HEADER  = null;
    private static By ABOUT_ITEM_SECTION_CONTENT = null;

    public static By getAboutItemSection() {
        ABOUT_ITEM_SECTION = PropertyUtil.getLocator("ABOUT_ITEM_SECTION");
        return ABOUT_ITEM_SECTION;
    }

    public static By getAboutItemSectionHeader(String aboutSectionHeader) {
        PropertyUtil.DynamicElementValue = aboutSectionHeader;
        ABOUT_ITEM_SECTION_HEADER = PropertyUtil.getLocator("ABOUT_ITEM_SECTION_HEADER");
        PropertyUtil.DynamicElementValue = "";
        return ABOUT_ITEM_SECTION_HEADER;
    }

    public static By getAboutItemSectionContent() {
        ABOUT_ITEM_SECTION_CONTENT = PropertyUtil.getLocator("ABOUT_ITEM_SECTION_CONTENT");
        return ABOUT_ITEM_SECTION_CONTENT;
    }
}
