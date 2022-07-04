package amazon.modules.elements;

import amazon.utils.PropertyUtil;
import org.openqa.selenium.By;

public class LeftSideNavElements extends BaseElements{

    private static By SIDE_NAV_CATEGORY  = null;
    private static By SIDE_NAV_SUB_CATEGORY  = null;
    private static By SIDE_NAV_SUPER_SUB_CATEGORY = null;

    public static By getSideNavCategory(String categoryHeader) {
        PropertyUtil.DynamicElementValue = categoryHeader;
        SIDE_NAV_CATEGORY = PropertyUtil.getLocator("SIDE_NAV_CATEGORY");
        PropertyUtil.DynamicElementValue = "";
        return SIDE_NAV_CATEGORY;
    }

    public static By getSideNavSubCategory(String subCategoryHeader) {
        PropertyUtil.DynamicElementValue = subCategoryHeader;
        SIDE_NAV_SUB_CATEGORY = PropertyUtil.getLocator("SIDE_NAV_SUB_CATEGORY");
        PropertyUtil.DynamicElementValue = "";
        return SIDE_NAV_SUB_CATEGORY;
    }

    public static By getSideNavSuperSubCategory(String superSubCategoryHeader) {
        PropertyUtil.DynamicElementValue = superSubCategoryHeader;
        SIDE_NAV_SUPER_SUB_CATEGORY = PropertyUtil.getLocator("SIDE_NAV_SUPER_SUB_CATEGORY");
        PropertyUtil.DynamicElementValue = "";
        return SIDE_NAV_SUPER_SUB_CATEGORY;
    }
}
