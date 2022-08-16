package selenide;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class TheInternet {
    @Test
    public void waits() {
        open("https://the-internet.herokuapp.com/dynamic_loading/1");
        WebDriver driver = WebDriverRunner.getWebDriver();

        $x("//*[@id=\"start\"]/button")
                .click();
        WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"finish\"]/h4")));
    }
}
