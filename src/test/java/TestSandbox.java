import amazon.config.EnvFactory;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.typesafe.config.Config;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import utils.SetupAndTeardown;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSandbox extends SetupAndTeardown {
    private static Config config = EnvFactory.getInstance().getConfig();
    private static final String HOME_PAGE_URL = config.getString("HOME_PAGE_URL");

    @Tag("smokeTest")
    @DisplayName("This test is for demo purpose only to show that the basic code works." +
            "You have to use the best practices that you normally use to design your tests")
    @Test
    void assertThatHomePageTitleIsCorrect() {
        open(HOME_PAGE_URL);
        assertEquals("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in", Selenide.title());
    }

    @Tag("smokeTest")
    @DisplayName("This test gets information about the item")
    @Test
    public void getInfoAboutItem() throws InterruptedException {

        open(HOME_PAGE_URL);

        $("#nav-hamburger-menu").click();
        $(By.linkText("TV, Appliances, Electronics")).scrollIntoView(true).click();
        $(By.linkText("Televisions")).click();

        $(By.linkText("Samsung")).scrollIntoView(true).click();

        $("#s-result-sort-select").selectOptionByValue("price-desc-rank");

        $$(".s-main-slot [data-index]").findBy(Condition.attribute("data-index", "2")).click();

        switchTo().window(1);
        $("#feature-bullets h1").scrollIntoView(true).shouldHave(text(" About this item "));

        ElementsCollection colls = $$("#feature-bullets li");
        for (SelenideElement e : colls) {
            System.out.println(">>>>> " + e.getText());
        }
    }
}
