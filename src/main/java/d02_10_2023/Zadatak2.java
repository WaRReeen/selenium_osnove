package d02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Zadatak2 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://itbootcamp.rs/");

        List<WebElement> buttonsMenu = driver.findElements(By.cssSelector("li.menu-item-has-children > a"));
        List<WebElement> dropdownMenu = driver.findElements(By.cssSelector("ul.dropdown-menu"));

        for (int i = 0; i < buttonsMenu.size(); i++) {
            new Actions(driver)
                    .moveToElement(buttonsMenu.get(i))
                    .perform();
            wait
                    .withMessage("Dropdown menu is not visible after mouse hover over the button")
                    .until(ExpectedConditions.visibilityOf(dropdownMenu.get(i)));
        }

        driver.quit();
    }
}
