package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
    LeftMenu leftmenu;
    CommonComponents cc;
    WebDriver driver;

    public LandingPage(WebDriver driver){
        this.driver= driver;
        this.cc= PageFactory.initElements(this.driver,CommonComponents.class);
        this.leftmenu= PageFactory.initElements(this.driver,LeftMenu.class);
    }




}
