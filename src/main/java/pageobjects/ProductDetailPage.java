package pageobjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductDetailPage {
    WebDriver driver;
    WebDriverWait wait;
    Logger log;

    public ProductDetailPage(WebDriver driver){
        this.driver= driver;
        this.wait=new WebDriverWait(driver,Duration.ofSeconds(5));
    }

    @FindBy(xpath = "//div[@id='feature-bullets']")
    WebElement aboutsection;
    public String getaboutsectiontext(){
        this.wait.until(ExpectedConditions.visibilityOf(aboutsection));
        return aboutsection.getText();
    }

    @FindBy(xpath="//h1[@class='a-size-base-plus a-text-bold' and contains(text(),'About this item')]")
    WebElement aboutthisitemheader;
    public boolean assertAboutthisitemvisible(){
        return aboutthisitemheader.isDisplayed();
    }
}
