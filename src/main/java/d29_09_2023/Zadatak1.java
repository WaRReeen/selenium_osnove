package d29_09_2023;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriver.get("https://web.dev/patterns/web-vitals-patterns/infinite-scroll/infinite-scroll/demo.html");

        new Select(webDriver.findElement(By.id("delay-select"))).selectByValue("2000");
        Thread.sleep(1000);

        for (int i = 0; i < 5; i++) {
            ((JavascriptExecutor) webDriver).executeScript("window.scrollBy(0,500)");
            Thread.sleep(100);
        }
        new Actions(webDriver).scrollToElement(webDriver.findElement(By.xpath("//div[@class='footer']"))).release().perform();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body//button"))).click();
        wait.until(ExpectedConditions
                .numberOfElementsToBe(By.xpath("//div[@id='infinite-scroll-container']/div[@class='item']"),8));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body//button[@disabled]")));
        webDriver.quit();
    }
}
