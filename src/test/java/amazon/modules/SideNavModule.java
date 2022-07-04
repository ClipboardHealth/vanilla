package amazon.modules;

import amazon.modules.elements.LeftSideNavElements;
import amazon.uiutils.SeleniumUtils;
import org.openqa.selenium.support.ui.Sleeper;

public class SideNavModule extends BaseModule{

    public static void scrollToShopByDepartmentCategory() {
        SeleniumUtils.scrollToElement(LeftSideNavElements.getSideNavCategory("shop by department"));
    }

    public static  void clickTVAppliancesAndElectronicsSubCategory(){
        SeleniumUtils.click(LeftSideNavElements.getSideNavSubCategory("TV, Appliances, Electronics"));
    }

    public static void clickTelevisionsCategory() throws InterruptedException {
        SeleniumUtils.click(LeftSideNavElements.getSideNavSuperSubCategory("Televisions"));
        Thread.sleep(5000);
    }
}
