import amazon.config.EnvFactory;
import amazon.factories.DriverFactory;
import com.typesafe.config.Config;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidateAmazonflow {
    private static Config config = EnvFactory.getInstance().getConfig();
    private static final String HOME_PAGE_URL = config.getString("HOME_PAGE_URL");
    private WebDriver driver = DriverFactory.getDriver();

    @Test
    void assertThatHomePageTitleIsCorrect() throws Exception{
        driver.get(HOME_PAGE_URL);
        assertEquals("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in", driver.getTitle());
        driver.findElement(By.xpath("//a[contains(@id,'nav-hamburger-menu')]/span")).click();
       String shopDepartment = driver.findElement(By.xpath("//div[contains(text(),'shop by department')]")).getText();
        assertEquals(shopDepartment,"Shop By Department");
        Actions ac = new Actions(driver);
       ac.moveToElement(driver.findElement(By.xpath("//div[contains(text(),'TV, Appliances, Electronics')]"))).click().perform();
        driver.findElement(By.xpath("//a[contains(text(),'Televisions')]")).click();
        Thread.sleep(3000);
        ac.moveToElement(driver.findElement(By.xpath("(//span[contains(text(),'Brands')])[2]"))).build().perform();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//span[contains(text(),'Samsung')]/..//label/i")));
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[contains(text(),'Featured')]")).click();
        driver.findElement(By.xpath("//a[contains(@id,'s-result-sort-select_2')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[contains(@data-cel-widget,'search_result_0')]/following-sibling::div[2]//img")).click();
        ArrayList<String> wid = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(wid.get(1));
        String val = driver.findElement(By.xpath("//h1[contains(text(),'About this item')]")).getText();
       assertEquals(val,"About this item");
        driver.switchTo().window(wid.get(0));
        System.out.println("Page title of parent window: " + driver.getTitle());
        driver.quit();
    }
}
