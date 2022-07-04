package amazon.modules;


import amazon.modules.elements.CategoryFiltersElements;
import amazon.uiutils.SeleniumUtils;

public class CategoryFilterModule {

    public static void scrollToBrandsFilter() throws InterruptedException {
        SeleniumUtils.scrollToElement(CategoryFiltersElements.getFilterType("Brands"));
        Thread.sleep(5000);
    }

    public static void selectSamsungBrandFilter() throws InterruptedException {
        SeleniumUtils.click(CategoryFiltersElements.getFilterLink("Samsung"));
        Thread.sleep(5000);
    }
}
