package d28_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();

        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

        webDriver.get("https://github.com/orgs/embedly/repositories?q=&type=all&language=&sort=");

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//details[@id='type-options']/summary"))).click();
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//*[@id='type-options']/details-menu/div/div/label[2]"))).click();
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//*[@id='org-repositories']/div/div/div[1]/div[2]/a"))).click();
        webDriver.quit();
    }
}
