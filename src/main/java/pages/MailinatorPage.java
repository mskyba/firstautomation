package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.regex.Pattern;

public class MailinatorPage extends BasePage{

    private By searchInput = By.id("search");
    private By sumbitButton = By.xpath("//button[text()='GO']");
    private By tdContainsName = By.xpath("//td[contains(text(),'Mykola Skyba')]");
    private By toLocator = By.xpath("//*[contains(text(),'mskyba')]");
    private By fromLocator = By.xpath("//*[contains(text(),'mbskyba@ukr.net')]");
    private By iframeLocator = By.id("texthtml_msg_body");
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
        driver.findElement(searchInput).sendKeys(account);
        driver.findElement(sumbitButton).click();
    }

    public void openingLastLetter(){
        String lastLetter = "Mykola Skyba";
        new WebDriverWait(driver, Duration.ofMillis(1000)).
                until(ExpectedConditions.textMatches(tdContainsName,
                        Pattern.compile(lastLetter)));
        driver.findElement(tdContainsName).click();

    }
     public void checkingLetter (){
         String to= "mskyba";
         new WebDriverWait(driver, Duration.ofMillis(1500)).
                 until(ExpectedConditions.textMatches(toLocator,
                         Pattern.compile(to)));

         String from= "mbskyba@ukr.net";
         new WebDriverWait(driver, Duration.ofMillis(1000)).
                 until(ExpectedConditions.textMatches(fromLocator,
                         Pattern.compile(from)));


         try{
             driver.switchTo().frame(driver.findElement(iframeLocator));
             String letterBody = "fsdfsdj";
             new WebDriverWait(driver, Duration.ofMillis(1000)).
                     until(ExpectedConditions.textMatches(letterBodyLocator,
                             Pattern.compile(letterBody)));         }
         finally {
             driver.switchTo().parentFrame();

         }

     }


}
