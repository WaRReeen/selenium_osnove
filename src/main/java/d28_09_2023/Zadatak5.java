package d28_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak5 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

        webDriver.get("http://seleniumdemo.com/?product=bdd-cucumber");

        WebElement button = webDriver.findElement(By.xpath("//li[contains(@class, 'nav__woocart')]/a"));
        new Actions(webDriver).click(button).perform();

        wait.until(ExpectedConditions.titleIs("Cart – Selenium Demo Page"));
        WebElement element = webDriver.findElement(By.xpath("//p[@class='cart-empty']"));

        if (element.getText().equals("Your cart is currently empty!")){
            System.out.println("Cart is empty!");
        }

        webDriver.quit();
    }
}