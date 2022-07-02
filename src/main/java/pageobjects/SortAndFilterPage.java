package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SortAndFilterPage {
    WebDriver driver;
    public SortAndFilterPage(WebDriver driver){
        this.driver= driver;
    }
    @FindBy(xpath = "//span[@id='a-autoid-0']")
    WebElement sortsection;
    public void expandsortsection(){
        this.sortsection.click();
    }

    public void sortby(String sortcriteria){
        this.driver.findElement(By.xpath("//a[contains(text(),"+"'"+sortcriteria+"'"+")]")).click();
    }
}
