package amazon.pages.common;

import amazon.utils.SynchronizationUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SideMenu {

    private static WebDriver driver;
    private static final String menuItemXpath = "//div[@id='hmenu-content']//div[text()='%s']";
    private static final String departmentXpath = "//a[@class='hmenu-item' and text()='%s']";
    private static final String footerXpath = "//div[@class='navFooterLine navFooterLogoLine']";

    public SideMenu(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    /*
        Using Dynamic xpath instead of directly searching menu items with text.
        Reason: Text like "Electronics" is very common and can easily occur more than once going ahead.
        Searching for text inside the menu reduces the chances of such conflict.
    */
    public void clickMenuItemByText(String menuName, String waitForMenuName){
        String xpath = String.format(menuItemXpath, menuName);
        SynchronizationUtils sync = new SynchronizationUtils();
        driver.findElement(By.xpath(xpath)).click();
        String department = String.format(departmentXpath, waitForMenuName);
        sync.waitUntilElementIsVisible(By.xpath(department));
    }

    public void clickDepartment(String department){
        String xpath = String.format(departmentXpath, department);
        SynchronizationUtils sync = new SynchronizationUtils();
        driver.findElement(By.xpath(xpath)).click();
        sync.waitUntilElementIsVisible(By.xpath(footerXpath));
    }
}
