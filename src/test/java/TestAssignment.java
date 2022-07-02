import amazon.config.EnvFactory;
import amazon.factories.DriverFactory;
import com.typesafe.config.Config;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pageobjects.CommonComponents;
import pageobjects.LeftMenu;
import pageobjects.ProductDetailPage;
import pageobjects.ResultPage;
import pageobjects.SortAndFilterPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAssignment {

    private static final Config config = EnvFactory.getInstance().getConfig();
    private static final String HOME_PAGE_URL = config.getString("HOME_PAGE_URL");
    private final WebDriver driver = DriverFactory.getDriver();
    private final LeftMenu leftmenu= PageFactory.initElements(driver,LeftMenu.class);
    private final SortAndFilterPage sortandfilterpage= PageFactory.initElements(driver,SortAndFilterPage.class);
    private final ResultPage resultpage= PageFactory.initElements(driver,ResultPage.class);
    private final CommonComponents common=PageFactory.initElements(driver,CommonComponents.class);
    private  final ProductDetailPage productdetails= PageFactory.initElements(driver,ProductDetailPage.class);
    private final Logger log=Logger.getLogger("TestAssignment");
    @BeforeTest
    public void setup(){
        PropertyConfigurator.configure("Log4j.properties");
    }
    @Tag("smokeTest")
    @DisplayName("This test is for demo purpose only to show that the basic code works." +
            "You have to use the best practices that you normally use to design your tests")
    @Test
    void assignmentTest() {
        log.info("**** Starting test assignmentTest ****");

        //Launch Site
        driver.manage().window().maximize();
        driver.get(HOME_PAGE_URL);

        //Assert pageload and load left menu
        assertEquals("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in", driver.getTitle());
        leftmenu.click_hamburger();
        common.waituntilpageloads();

        //Select Given link from left menu
        leftmenu.click_menuitem("TV, Appliances, Electronics");
        common.waituntilpageloads();

        //Select Given link from left submenu
        leftmenu.click_submenuitem("Televisions");
        common.waituntilpageloads();

        //Select Checkbox to filter
        leftmenu.click_filtermenu_chkbox("Samsung");
        common.waituntilpageloads();

        //Expand the sort panel
        sortandfilterpage.expandsortsection();
        common.waituntilpageloads();

        //Enter Sort criteria
        sortandfilterpage.sortby("Price: High to Low");
        resultpage.findlisteditemByposition(2);

        //Switch to window assert product section and cpture about product test
        common.switchToWindow();
        Assert.assertTrue(productdetails.assertAboutthisitemvisible(), "About This product section is not visible");
        log.info(productdetails.getaboutsectiontext());
        log.info("**** test assignmentTest Finished ****");
    }

    @AfterTest
    public void tearDown(){
        this.driver.quit();
    }
}
