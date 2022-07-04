package amazon.test;

import amazon.config.EnvFactory;
import amazon.uiutils.SeleniumUtils;
import amazon.utils.DriverManager;
import amazon.utils.PropertyUtil;
import com.typesafe.config.Config;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class TestBase {
    private static Config config = EnvFactory.getInstance().getConfig();
    public static WebDriver driver = DriverManager.getDriver();

    static {
        PropertyUtil.loadPropertyFile("ui-locators.properties");
    }

    @BeforeEach
    public void openHomePage(){
        SeleniumUtils.openURL(config.getString("HOME_PAGE_URL"));
    }

    @AfterEach
    public void closeWebDriver(){
        DriverManager.closeDriver();
    }
}
