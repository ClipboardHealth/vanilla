import amazon.config.EnvFactory;
import amazon.factories.DriverFactory;
import amazon.pages.articlePage;
import amazon.pages.filterPage;
import amazon.pages.homePage;
import amazon.pages.resultPage;

import com.typesafe.config.Config;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;

import amazon.utils.utils;

public class TestClipBoardHealth {
    private static Config config = EnvFactory.getInstance().getConfig();
    private static final String HOME_PAGE_URL = config.getString("HOME_PAGE_URL");
    private static WebDriver driver = DriverFactory.getDriver();
    Logger logger = (Logger) LogManager.getLogger(TestClipBoardHealth.class);

    @BeforeEach
    public void openBrowser() {
        driver.get(HOME_PAGE_URL);
    }

    @Tag("assignment")
    @DisplayName("This test is for the assignment of Clip Board Health.")
    @Test
    void assertAssignmentClipBoardHealth() {
        utils utils = new utils(driver);
        homePage homePage = new homePage(driver);
        filterPage filterPage = new filterPage(driver);
        resultPage resultPage = new resultPage(driver);
        articlePage articlePage = new articlePage(driver);

        homePage.openHamburguerMenu();
        homePage.openTvApplianceElectronicsSubMenu();
        homePage.openTelevisionsSubMenu();
        homePage.selectCheckoxIntoTitle("Brands", "Samsung");
        filterPage.sortByPriceHighToLow();
        resultPage.selectResultByIndex(1);
        utils.switchTab(1);
        assertTrue(articlePage.getAboutThisItemSectionText().equalsIgnoreCase("About this item"),
                "About this item section was not found");
        List<WebElement> bullets = articlePage.getBulletList();
        for (int i = 0; i < bullets.size(); i++) {
            System.out.println("*" + bullets.get(i).getText());
            logger.info("*" + bullets.get(i).getText());
        }
    }

    @AfterAll
    public static void closeBrowser() {
        driver.quit();
    }
}
