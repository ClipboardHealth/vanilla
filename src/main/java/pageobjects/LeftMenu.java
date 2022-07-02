package pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LeftMenu {

    WebDriver driver;
    CommonComponents cc;

    public LeftMenu(WebDriver driver){
        this.driver= driver;
        this.cc= PageFactory.initElements(this.driver,CommonComponents.class);
    }

    @FindBy(xpath ="//span[@class='hm-icon-label']" )
    WebElement hamburger;
    public void click_hamburger(){
        this.hamburger.click();
    }

    public void click_menuitem(String strmenuitem){
        WebElement menuitem=this.driver.findElement(By.xpath("//a/div[contains(text(),"+"'"+strmenuitem+"'"+")]"));
        this.cc.scrollintoview(this.driver,menuitem);
        menuitem.click();
    }

    public void click_submenuitem(String strmenuitem){
        WebElement menuitem=this.driver.findElement(By.xpath("//a[contains(text(),"+"'"+strmenuitem+"'"+")]"));
        this.cc.scrollintoview(this.driver,menuitem);
        menuitem.click();
    }

    public void click_filtermenu_chkbox(String strmenuitem){
        WebElement menuitem=this.driver.findElement(By.xpath("//a/span[contains(text(),"+"'"+strmenuitem+"'"+") and @class='a-size-base a-color-base']"));
        this.cc.scrollintoview(this.driver,menuitem);
        menuitem.click();
    }
}
