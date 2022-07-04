package amazon.modules.elements;

import amazon.utils.PropertyUtil;
import org.openqa.selenium.By;

public class CategoryFiltersElements extends BaseElements{

    private static By FILTER_TYPE  = null;
    private static By FILTER_LINK  = null;

    public static By getFilterType(String filterType) {
        PropertyUtil.DynamicElementValue = filterType;
        FILTER_TYPE = PropertyUtil.getLocator("FILTER_TYPE");
        PropertyUtil.DynamicElementValue = "";
        return FILTER_TYPE;
    }

    public static By getFilterLink(String filterLinkText) {
        PropertyUtil.DynamicElementValue = filterLinkText;
        FILTER_LINK = PropertyUtil.getLocator("FILTER_LINK");
        PropertyUtil.DynamicElementValue = "";
        return FILTER_LINK;
    }

}
