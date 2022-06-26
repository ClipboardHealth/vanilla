import amazon.factories.DriverFactory;
import amazon.pages.common.SideMenu;
import amazon.pages.home.Home;
import amazon.pages.search.SearchFilter;
import amazon.pages.search.SearchResults;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClipboardHealthAssignment {
    private static WebDriver driver = DriverFactory.getDriver();
    Logger logger = LogManager.getLogger(ClipboardHealthAssignment.class);

    @Test
    void clipboardHealthAssignment(){
        Home home = new Home(driver);
        SideMenu sideMenu = new SideMenu(driver);
        SearchFilter filter = new SearchFilter(driver);
        SearchResults results = new SearchResults(driver);
        home.visitHome();
        home.selectHamburgerMenu();
        sideMenu.clickMenuItemByText("TV, Appliances, Electronics", "Televisions");
        sideMenu.clickDepartment("Televisions");
        assertNotNull(driver.findElement(By.xpath("//span[text()='Televisions']")));
        logger.info("Visited Televisions menu successfully.");
        List<String> brands = new ArrayList<>();
        brands.add("Samsung");
        filter.selectFeaturedBrands(brands);
        logger.info("Filtered brands successfully.");
        results.sortResults("Price: High to Low");
        String productTitle = results.selectSearchResult(2);
        assertTrue(productTitle.toUpperCase().contains("ABOUT THIS ITEM"));
        logger.info(productTitle);
    }

    @AfterAll
    static void tearDown(){
        driver.quit();
    }
}
