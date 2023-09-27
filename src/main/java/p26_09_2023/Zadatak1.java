package p26_09_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

public class Zadatak1 {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://s.bootsnipp.com/iframe/oV91g");


        List<WebElement> elements = driver.findElements(By.cssSelector("ul.pagination a.page_link"));
        for (int i = 0; i < elements.size(); i++) {
            WebElement element = elements.get(i);
            element.click();

            Thread.sleep(1000);
        }
        driver.close();

        }

    }









