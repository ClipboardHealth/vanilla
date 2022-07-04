package amazon.modules.elements;

import amazon.utils.PropertyUtil;
import org.openqa.selenium.By;

public class FilterResultElements {

    private static By SORT_BY_DROPDOWN  = null;
    private static By RESULT_CARD = null;

    public static By getSortByDropdown() {
        SORT_BY_DROPDOWN = PropertyUtil.getLocator("SORT_BY_DROPDOWN");
        return SORT_BY_DROPDOWN;
    }

    public static By getResultCard(int resultCardIndex){
        PropertyUtil.DynamicElementValue = String.valueOf(resultCardIndex);
        RESULT_CARD = PropertyUtil.getLocator("RESULT_CARD");
        PropertyUtil.DynamicElementValue = "";
        return RESULT_CARD;
    }
}
