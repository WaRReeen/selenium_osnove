package p26_09_2023;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak5 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("http://cms.demo.katalon.com/my-account/");

        WebElement rememberMeCheckbox = driver.findElement(By.id("rememberme"));
        rememberMeCheckbox.click();

        if (rememberMeCheckbox.isSelected()) {
            System.out.println("Checkbox je označen.");
        } else {
            System.out.println("Checkbox nije označen.");
        }

        driver.quit();
    }
}
