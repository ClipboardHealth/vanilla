package amazon.modules;

import amazon.modules.elements.LeftSideNavElements;
import amazon.modules.elements.ProductDetailsElements;
import amazon.uiutils.SeleniumUtils;

public class ProductDetailsModule {

    public static void scrollToProductAboutSection() {
        SeleniumUtils.scrollToElement(ProductDetailsElements.getAboutItemSection());
    }

    public static boolean checkProductAboutSectionHeader(){
        return SeleniumUtils.checkIfExists(ProductDetailsElements.getAboutItemSectionHeader(" About this item "));
    }

    public static String getProductAboutSectionContent(){
        return SeleniumUtils.getValue(ProductDetailsElements.getAboutItemSectionContent());
    }
}
