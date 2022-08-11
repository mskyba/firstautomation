//package selenide;
//
//import com.codeborne.selenide.*;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//import pages.google.GoogleHomePage;
//
//import static com.codeborne.selenide.CollectionCondition.*;
//import static com.codeborne.selenide.Condition.*;
//import static com.codeborne.selenide.Selenide.*;
//
//public class GoogleTest {
//
//    @BeforeClass
//    public void setUp() {
//        Configuration.holdBrowserOpen = true;
//        Configuration.savePageSource = false;
//        Configuration.timeout = 4000;//по умолчанию
//        Configuration.browserSize = "1920x1080";
//    }
//
//    @Test
//    public void userShouldSearch() {
//        open("https://google.com");
//        GoogleHomePage googleHomePage = new GoogleHomePage();
//        googleHomePage.waitUntilSearchFieldDisplayed()
//                .setSearchText("Selenide")
//                .pressEnter();
//
//
//
//
////        googleHomePage.searchField
////                .shouldBe(visible)
////                .setValue("Selenide")
////                .pressEnter();
////        $$x("//h3[contains(text(), 'Selenide')]")
////                .filter(visible)
////                .shouldHave(sizeGreaterThanOrEqual(7))
////                .get(0)
////                .click();
////        $(".donate_header")
////                .shouldHave(text("Selenide Supports Ukraine \uD83C\uDDFA\uD83C\uDDE6"));
//    }
//}