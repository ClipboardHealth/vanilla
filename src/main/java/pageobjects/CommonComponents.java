package pageobjects;

import org.checkerframework.checker.units.qual.s;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class CommonComponents {

        WebDriverWait wait;
        WebDriver driver;
        public CommonComponents(WebDriver driver){
            this.driver=driver;
            this.wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        }
        public void scrollintoview(WebElement element){
            Actions actions = new Actions(this.driver);
            actions.moveToElement(element);
            actions.perform();
            this.wait.until(ExpectedConditions.visibilityOf(element));
        }

        public void switchToWindow(){
            Set<String> s=this.driver.getWindowHandles();
            Iterator<String> I1= s.iterator();
            String parent=this.driver.getWindowHandle();
            while(I1.hasNext()) {
                String child_window = I1.next();
                if (! parent.equals(child_window)) {
                    this.driver.switchTo().window(child_window);
                }
            }
        }

        public void waituntilpageloads(){
            new WebDriverWait(this.driver, Duration.ofSeconds(10)).until(
                    webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        }

}
