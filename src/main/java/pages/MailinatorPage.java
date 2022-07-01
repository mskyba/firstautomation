package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.regex.Pattern;

public class MailinatorPage extends BasePage{

    @FindBy(id = "search")
    private WebElement searchInputElement;

    @FindBy(xpath = "//button[text()='GO']")
    private WebElement sumbitButtonElement;
    @FindBy(xpath = "//td[contains(text(),'Mykola Skyba')]")
    private WebElement tdContainsNameElement;

    @FindBy(id = "texthtml_msg_body")
    private WebElement iframeLocatorElement;
    @FindBy(id = "/html/body")
    private By letterBodyLocator = By.xpath("/html/body");



    public MailinatorPage (WebDriver driver) {
        super(driver);
        pageUrl = "https://www.mailinator.com/";
    }
    public void openingNewTab (){
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.COMMAND+"t");
    }
    public void navigate(){
        driver.get(pageUrl);
    }
    public void openingMailinator (String account){
        searchInputElement.sendKeys(account);
        sumbitButtonElement.click();
    }

    public void openingLastLetter(){
        String lastLetter = "Mykola Skyba";
        new WebDriverWait(driver, Duration.ofMillis(1000)).
                until(ExpectedConditions.textMatches(By.xpath("//td[contains(text(),'Mykola Skyba')]"),
                        Pattern.compile(lastLetter)));
        tdContainsNameElement.click();

    }
     public void checkingLetter (){
         String to= "mskyba";
         new WebDriverWait(driver, Duration.ofMillis(1500)).
                 until(ExpectedConditions.textMatches(By.xpath("//*[contains(text(),'mskyba')]"),
                         Pattern.compile(to)));

         String from= "mbskyba@ukr.net";
         new WebDriverWait(driver, Duration.ofMillis(1000)).
                 until(ExpectedConditions.textMatches(By.xpath("//*[contains(text(),'mbskyba@ukr.net')]"),
                         Pattern.compile(from)));


         try{
             driver.switchTo().frame(iframeLocatorElement);
             String letterBody = "fsdfsdj";
             new WebDriverWait(driver, Duration.ofMillis(1000)).
                     until(ExpectedConditions.textMatches(By.xpath("/html/body"),
                             Pattern.compile(letterBody)));         }
         finally {
             driver.switchTo().parentFrame();

         }

     }


}
