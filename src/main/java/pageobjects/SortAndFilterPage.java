package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SortAndFilterPage {
    WebDriver driver;
    WebDriverWait wait;
    public SortAndFilterPage(WebDriver driver){
        this.driver= driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    @FindBy(xpath = "//span[@id='a-autoid-0']")
    WebElement sortsection;
    public void expandsortsection(){
        this.wait.until(ExpectedConditions.visibilityOf(sortsection));
        this.sortsection.click();
    }

    public void sortby(String sortcriteria){
        this.driver.findElement(By.xpath("//a[contains(text(),"+"'"+sortcriteria+"'"+")]")).click();
    }
}
