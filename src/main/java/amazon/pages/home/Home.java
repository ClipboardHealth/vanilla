package amazon.pages.home;

import amazon.config.EnvFactory;
import com.typesafe.config.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
    private static WebDriver driver;
    private static Config config = EnvFactory.getInstance().getConfig();
    private static final String HOME_PAGE_URL = config.getString("HOME_PAGE_URL");
    @FindBy(id="nav-hamburger-menu")
    WebElement hamburgerMenu;
    public Home(WebDriver driver){
        /*
            Using PageFactory to initialize elements in constructor.
            We don't need to call driver.findElement() to identify objects.
         */
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void visitHome(){
        driver.get(HOME_PAGE_URL);
    }

    public void selectHamburgerMenu(){
        hamburgerMenu.click();
    }
}
