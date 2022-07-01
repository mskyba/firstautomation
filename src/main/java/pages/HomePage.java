package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.regex.Pattern;

public class HomePage extends BasePage {

    @FindBy(css = ".primary.compose")
    private WebElement writeLetterButtonElement;
    @FindBy(name = "toFieldInput")
    private WebElement toInputElement;
    @FindBy(name = "subject")
    private WebElement toSubjectInputElement;

    @FindBy(id = "tinymce" )
    private WebElement letterBodyElement;
    @FindBy(css = ".screen__head .send.button" )
    private WebElement sendButtonElement;

    @FindBy(id = "mce_0_ifr")
    private WebElement bodyIframeElement;

    public HomePage(WebDriver driver) {
        super(driver);
        pageUrl = "https://mail.ukr.net/desktop";
        PageFactory.initElements(driver, this);
    }

    public void writeLetter(String to, String subject, String body) {
        toInputElement.sendKeys(to);
        toSubjectInputElement.sendKeys(subject);
        try {
            driver.switchTo().frame((bodyIframeElement));
            letterBodyElement.sendKeys(body);
        } finally {
            driver.switchTo().parentFrame();

        }

    }

    public void clickWriteLetter() {
        webDriverWait.until(ExpectedConditions.visibilityOf(writeLetterButtonElement));
        writeLetterButtonElement.click();
    }

    public void sendLetter() {
        sendButtonElement.click();
    }

    public static void waitUntillPageLoaded() {
        new WebDriverWait(driver, Duration.ofSeconds(4)).until(ExpectedConditions.urlContains(pageUrl));
    }

    public static void waitUntillPendingModalLoaded() {
        new WebDriverWait(driver, Duration.ofMillis(700)).
                until(ExpectedConditions.textToBe(By.className("sendmsg__ads-loading"), "Лист надсилається"));
    }

    public static void waitLetterSent() {
        String name = " надіслано";
        new WebDriverWait(driver, Duration.ofMillis(700)).
                until(ExpectedConditions.textMatches(By.className("sendmsg__ads-ready"), Pattern.compile(name)));
    }


}
