package d28_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

        webDriver.get("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");

        webDriver.findElement(By.id("basic-primary-trigger")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'toast-fixed show')][@id='basic-primary-example']")));
        Thread.sleep(1000);
        webDriver.findElement(By.id("basic-secondary-trigger")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'toast-fixed show')][@id='basic-secondary-example']")));
        Thread.sleep(1000);
        webDriver.findElement(By.id("basic-success-trigger")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'toast-fixed show')][@id='basic-success-example']")));
        Thread.sleep(1000);
        webDriver.findElement(By.id("basic-danger-trigger")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'toast-fixed show')][@id='basic-danger-example']")));
        Thread.sleep(1000);
        webDriver.findElement(By.id("basic-warning-trigger")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'toast-fixed show')][@id='basic-warning-example']")));
        Thread.sleep(1000);
        webDriver.findElement(By.id("basic-info-trigger")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'toast-fixed show')][@id='basic-info-example']")));
        Thread.sleep(1000);
        webDriver.findElement(By.id("basic-light-trigger")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'toast-fixed show')][@id='basic-light-example']")));
        Thread.sleep(1000);
        webDriver.findElement(By.id("basic-dark-trigger")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'toast-fixed show')][@id='basic-dark-example']")));
        Thread.sleep(1000);

        webDriver.quit();
    }
}
