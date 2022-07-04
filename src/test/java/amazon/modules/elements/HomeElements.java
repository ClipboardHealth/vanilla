package amazon.modules.elements;

import amazon.utils.PropertyUtil;
import org.openqa.selenium.By;

public class HomeElements extends BaseElements {

    private static By BREADCRUMB_OPTION_PATH  = null;

    public static By getBreadcrumbMenu(String breadcrumbLabel) {
        switch (breadcrumbLabel) {
            case "All":
                BREADCRUMB_OPTION_PATH = PropertyUtil.getLocator("BREADCRUMB_OPTION_ALL");
                break;
            case "Best Seller":
                BREADCRUMB_OPTION_PATH = PropertyUtil.getLocator("BREADCRUMB_OPTION_BEST_SELLER");
                break;
        }
        return BREADCRUMB_OPTION_PATH;
    }
}

