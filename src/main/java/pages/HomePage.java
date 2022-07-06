package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.regex.Pattern;

public class HomePage extends BasePage {

    private By writeLetterButton = By.xpath("//*[@id=\"content\"]/aside/button");
    private By toInput = By.name("toFieldInput");
    private By toSubjectInput = By.name("subject");
    private By letterBody = By.id("tinymce");
    private By sendButton = By.cssSelector(".screen__head .send.button");
    private By bodyIframe = By.cssSelector("#mce_0_ifr");
    public HomePage(WebDriver driver) {
        super(driver);
        pageUrl = "https://mail.ukr.net/desktop";
    }

    public void writeLetter(String to, String subject,  String body) {
        driver.findElement(toInput).sendKeys(to);
        driver.findElement(toSubjectInput).sendKeys(subject);
        try{
            driver.switchTo().frame(driver.findElement(bodyIframe));
            driver.findElement(letterBody).sendKeys(body);
        }
        finally {
            driver.switchTo().parentFrame();

        }

    }

    public void clickWriteLetter() {
        driver.findElement(writeLetterButton).click();
    }

    public void sendLetter() {
        driver.findElement(sendButton).click();
    }

    public static void waitUntillPageLoaded() {
        new WebDriverWait(driver, Duration.ofSeconds(4)).until(ExpectedConditions.urlContains(pageUrl));
    }
    public static void waitUntillPendingModalLoaded() {
        new WebDriverWait(driver, Duration.ofMillis(400)).
                until(ExpectedConditions.textToBe(By.className("sendmsg__ads-loading"), "Лист надсилається"));
    }
    public static void waitLetterSent() {
        String name = " надіслано";
        new WebDriverWait(driver, Duration.ofMillis(400)).
                until(ExpectedConditions.textMatches(By.className("sendmsg__ads-ready"), Pattern.compile(name)));
    }


}
