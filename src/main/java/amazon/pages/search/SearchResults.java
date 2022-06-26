package amazon.pages.search;

import amazon.utils.SynchronizationUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;

public class SearchResults {
    private static WebDriver driver;
    private static SynchronizationUtils sync = new SynchronizationUtils();
    @FindBy(xpath = "//span[text()='Sort by:']")
    WebElement sortBy;
    @FindBy(xpath = "//div[@class='a-section aok-relative s-image-square-aspect']")
    List<WebElement> searchResults;
    @FindBy(xpath = "//h1[text()=' About this item ']")
    WebElement aboutThisText;
    @FindBy(id = "feature-bullets")
    WebElement productDescription;
    private static final String resultsXpath = "//span[text()='RESULTS']";
    private static final String sortStrategyXpath = "//*[text()='%s']";

    public SearchResults(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void sortResults(String sortStrategy){
        sortBy.click();
        String strategyXpath = String.format(sortStrategyXpath, sortStrategy);
        WebElement strategy = driver.findElement(By.xpath(strategyXpath));
        strategy.click();
        /*
            Doing this as an extreme measure.
            Sorting time is occasionally inconsistent.
            This is causing wrong results to be picked up in 1 out of 5 executions.
            Thread.sleep() giving consistent output.
         */
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        sync.waitUntilElementIsVisible(By.xpath(resultsXpath));
    }

    public String selectSearchResult(int index){
        searchResults.get(index).click();
        List<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        return productDescription.getText();
    }
}
