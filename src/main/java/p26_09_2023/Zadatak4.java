package p26_09_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Zadatak4 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com/");

        WebElement categoryDropdown = driver.findElement(By.xpath("//*[@id=\"gh-cat\"]"));

        Select select = new Select(categoryDropdown);
        select.selectByVisibleText("Crafts");
        driver.quit();
    }
}
