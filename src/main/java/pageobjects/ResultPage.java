package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ResultPage {
    WebDriver driver;
    public ResultPage(WebDriver driver){
        this.driver= driver;
    }

    @FindBy(xpath = "//div[@class='a-section a-spacing-small s-padding-left-small s-padding-right-small']")
    List<WebElement>lst_results;
    public void findlisteditemByposition(int position){
        this.lst_results.removeIf(webele -> webele.getText().contains("Currently unavailable."));
        this.lst_results.get(position).click();
    }
}
