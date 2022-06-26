package amazon.pages.search;

import amazon.utils.SynchronizationUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class SearchFilter {
    private static WebDriver driver;
    private static final String featuredBrands = "//span[text()='%s']";

    private static final String resultsXpath = "//span[text()='RESULTS']";
    public SearchFilter(WebDriver driver){
        this.driver = driver;
    }

    /*
        Method to select multiple brands on search filter section
     */
    public void selectFeaturedBrands(List<String> brands){
        SynchronizationUtils sync = new SynchronizationUtils();
        for (String brand : brands){
            String brandXpath = String.format(featuredBrands, brand);
            driver.findElement(By.xpath(brandXpath)).click();
            sync.waitUntilElementIsVisible(By.xpath(resultsXpath));
        }
    }
}
