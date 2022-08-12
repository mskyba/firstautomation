package selenide;

import com.codeborne.selenide.*;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.google.GoogleHomePage;

import java.net.MalformedURLException;
import java.net.URI;
import java.util.Map;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class GoogleTest {

    @BeforeClass
    public void setUpSelenoid() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "104.0");
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        RemoteWebDriver driver = new RemoteWebDriver(
                URI.create("http://selenoid:4444/wd/hub").toURL(),
                capabilities
        );
    }


        @Test
    public void userShouldSearch() {
        open("https://google.com");
        GoogleHomePage googleHomePage = new GoogleHomePage();
        googleHomePage.waitUntilSearchFieldDisplayed()
                .setSearchText("Selenide")
                .pressEnter();
        $$x("//br/following-sibling::h3")
                .shouldBe(sizeGreaterThanOrEqual(7))
                .get(0)
                .click();
        webdriver().shouldHave(url("https://ru.selenide.org/"));
        $x("//h3[contains(text(), 'Селенид поддерживает Украину \uD83C\uDDFA\uD83C\uDDE6\n')]");
        $x("//a[contains(text(),'Блог')]")
                .click();
        webdriver().shouldHave(url("https://ru.selenide.org/blog.html"));











//        googleHomePage.searchField
//                .shouldBe(visible)
//                .setValue("Selenide")
//                .pressEnter();
//        $$x("//h3[contains(text(), 'Selenide')]")
//                .filter(visible)
//                .shouldHave(sizeGreaterThanOrEqual(7))
//                .get(0)
//                .click();
//        $(".donate_header")
//                .shouldHave(text("Selenide Supports Ukraine \uD83C\uDDFA\uD83C\uDDE6"));
    }
}