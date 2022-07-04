package amazon.modules;

import amazon.modules.elements.HomeElements;
import amazon.uiutils.SeleniumUtils;
import amazon.utils.PropertyUtil;

public class HomeModule extends BaseModule{

    public static void clickAll(){
        SeleniumUtils.click(HomeElements.getBreadcrumbMenu("All"));
    }

    public static void clickBestSeller(){
        SeleniumUtils.click(HomeElements.getBreadcrumbMenu("Best Seller"));
    }
}
