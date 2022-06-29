package ukrnet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MailinatorPage;
import testdata.User;


public class UkrNetTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {

        System.setProperty("selenium.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
    }


    @Test
    public void sendEmailToMailinatorTest() {
        User user = new User("mbskyba", "Qwerty234");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigate();
        loginPage.login(user);
        HomePage homePage = new HomePage(driver);
        homePage.waitUntillPageLoaded();
        homePage.clickWriteLetter();
        homePage.writeLetter("mskyba@mailinator.com", "qa", "fsdfsdj");
        homePage.sendLetter();
        homePage.waitUntillPendingModalLoaded();
        homePage.waitLetterSent();
        // Mailinator
        MailinatorPage mailinatorPage = new MailinatorPage(driver);
        mailinatorPage.openingNewTab();
        mailinatorPage.navigate();

        mailinatorPage.openingMailinator("mskyba");
        mailinatorPage.openingLastLetter();
        mailinatorPage.checkingLetter();

    }


    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
