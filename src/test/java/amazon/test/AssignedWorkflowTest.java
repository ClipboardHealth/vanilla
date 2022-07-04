package amazon.test;

import amazon.modules.CategoryFilterModule;
import amazon.modules.FiltersResultModule;
import amazon.modules.HomeModule;
import amazon.modules.ProductDetailsModule;
import amazon.modules.SideNavModule;
import amazon.utils.DriverManager;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class AssignedWorkflowTest extends TestBase {

    private static final Logger logger = Logger.getLogger(AssignedWorkflowTest.class);

    @DisplayName("This test is to find second highest value television at Television section for Samsung brand")
    @Test
    void verifyAboutSectionForSecondHighestValueTelevisionOfSamsungBrand() throws InterruptedException {
        logger.info("Title : " + driver.getTitle());
        HomeModule.clickAll();
        SideNavModule.scrollToShopByDepartmentCategory();
        SideNavModule.clickTVAppliancesAndElectronicsSubCategory();
        SideNavModule.clickTelevisionsCategory();
        CategoryFilterModule.scrollToBrandsFilter();
        CategoryFilterModule.selectSamsungBrandFilter();
        FiltersResultModule.selectSortByPriceHighToLow();
        FiltersResultModule.clickOnSecondResultCard();
        DriverManager.switchToWindowOpened();
        ProductDetailsModule.scrollToProductAboutSection();
        logger.info("About this item content is : \n" + ProductDetailsModule.getProductAboutSectionContent());
        Assertions.assertTrue(ProductDetailsModule.checkProductAboutSectionHeader(), "About this item header is incorrect");
    }
}
