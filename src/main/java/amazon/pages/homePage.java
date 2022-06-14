package amazon.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import amazon.utils.utils;
import amazon.consts.consts;

public class homePage {

    protected WebDriver driver;
    protected utils utils;

    public homePage(WebDriver driver) {
        this.driver = driver;
        utils = new utils(driver);
    }

    public void openHamburguerMenu() {
        driver.findElement(By.id(consts.NAV_HAMBURGUER_MENU_ID)).click();
    }

    public void openTvApplianceElectronicsSubMenu() {
        utils.hoverAndClick(By.linkText(consts.TV_APPLIANCES_ELECTRONICS_LINKTEXT));
    }

    public void openTelevisionsSubMenu() {
        utils.hoverAndClick(By.linkText(consts.TELEVISIONS_LINKTEXT));
    }

    public void selectCheckoxIntoTitle(String title, String checkboxValue) {
        utils.waitForElementToBePresent(By.cssSelector(consts.FILTER_OPTIONS_CSS));

        List<WebElement> filterOptions = driver.findElements(By.cssSelector(consts.FILTER_OPTIONS_CSS));
        int e = 0;
        for (int i = 0; i < filterOptions.size(); i++) {
            String val = filterOptions.get(i).findElement(By.cssSelector("span")).getText();
            if (val.equalsIgnoreCase(title)) {
                e = i + 1;
                break;
            }
        }
        List<WebElement> optionCheckboxes = driver.findElements(
                By.cssSelector(consts.FILTER_OPTIONS_CHECKBOXES_CSS.replace("@@ID@@", String.valueOf(e))));
        for (int i = 0; i < optionCheckboxes.size(); i++) {
            String val = optionCheckboxes.get(i).getText();
            if (val.equalsIgnoreCase(checkboxValue)) {
                optionCheckboxes.get(i).click();
                break;
            }
        }
    }
}