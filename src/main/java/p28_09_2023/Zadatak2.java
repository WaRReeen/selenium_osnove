package p28_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("file:///C:/Users/waren/Downloads/Zadatak4.html");
        WebElement showInButton = driver.findElement(By.xpath("//*[@id=\"showInBtn\"]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        for (int i = 0; i < 5; i++) {
            showInButton.click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"id-0\" +i+ ]")));
        }
        driver.quit();
    }
}