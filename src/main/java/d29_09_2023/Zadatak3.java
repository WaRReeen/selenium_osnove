package d29_09_2023;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak3 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        webDriver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(webDriver,Duration.ofSeconds(10));
        webDriver.get("https://docs.katalon.com/");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html[@data-theme='light']")));
        System.out.println("Theme is light!");

        webDriver.findElement(By.xpath("//button[contains(@class, 'toggleButton_rCf9')]")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html[@data-theme='dark']")));
        System.out.println("Theme is dark!");

        new Actions(webDriver).keyDown(Keys.LEFT_CONTROL).sendKeys("k").keyUp(Keys.LEFT_CONTROL).perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='docsearch-input']")));

        try {
            webDriver.findElement(By.xpath("//input[@id='docsearch-input'][@type='search']"));
        }catch (Exception e){
            throw e;
        }

        webDriver.quit();
    }
}
