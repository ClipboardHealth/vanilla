import amazon.config.EnvFactory;
import amazon.factories.DriverFactory;
import com.typesafe.config.Config;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageobjects.LandingPage;
import pageobjects.LeftMenu;
import pageobjects.ResultPage;
import pageobjects.SortAndFilterPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAssignment {

    private static final Config config = EnvFactory.getInstance().getConfig();
    private static final String HOME_PAGE_URL = config.getString("HOME_PAGE_URL");
    private final WebDriver driver = DriverFactory.getDriver();
    private final LeftMenu leftmenu= PageFactory.initElements(driver,LeftMenu.class);
    private final SortAndFilterPage sf= PageFactory.initElements(driver,SortAndFilterPage.class);
    private final ResultPage rp= PageFactory.initElements(driver,ResultPage.class);

    @Tag("smokeTest")
    @DisplayName("This test is for demo purpose only to show that the basic code works." +
            "You have to use the best practices that you normally use to design your tests")
    @Test
    void assignmentTest() {
        driver.manage().window().maximize();
        driver.get(HOME_PAGE_URL);
        assertEquals("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in", driver.getTitle());
        leftmenu.click_hamburger();
        leftmenu.click_menuitem("TV, Appliances, Electronics");
        leftmenu.click_submenuitem("Televisions");
        leftmenu.click_filtermenu_chkbox("Samsung");
        sf.expandsortsection();
        sf.sortby("Price: High to Low");
        rp.findlisteditemByposition(2);
    }
}
