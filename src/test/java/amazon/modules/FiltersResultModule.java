package amazon.modules;

import amazon.modules.elements.FilterResultElements;
import amazon.uiutils.SeleniumUtils;

public class FiltersResultModule {

    public static void selectSortByPriceHighToLow() {
        SeleniumUtils.selectValue(FilterResultElements.getSortByDropdown(), "Price: High to Low");
    }

    public static void clickOnSecondResultCard(){
        SeleniumUtils.click(FilterResultElements.getResultCard(2));
    }
}
