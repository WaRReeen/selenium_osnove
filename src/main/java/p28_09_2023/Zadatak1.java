package p28_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/modal-dialogs");
        TestHelper testHelper = new TestHelper(driver);
        testHelper.setImplicitWait(10);

        boolean elementExists = true;
        WebElement largeModal = null;

        By largeModalButtonLocator = By.id("showLargeModal");
        try {
            largeModal = driver.findElement(largeModalButtonLocator);
        } catch (org.openqa.selenium.NoSuchElementException e) {
            elementExists = false;
        }
        if (elementExists) {
            largeModal.click();
        } else {
            System.out.println("Dugme \"Large modal\" ne postoji.");
        }
        By dialogLocator = By.id("example-modal-sizes-title-lg");
        if (testHelper.elementExists(dialogLocator)) {
            WebElement dialog = driver.findElement(dialogLocator);
            System.out.println("Dijalog se prikazao.");
        } else {
            System.out.println("Dijalog se nije prikazao.");
        }
        By largeModalElementLocator = By.cssSelector("#app > div > div > div.row > div.col-12.mt-4.col-md-6");
        if (testHelper.elementExists(largeModalElementLocator)) {
            System.out.println("Element \"Large modal\" postoji.");
        } else {
            System.out.println("Element \"Large modal\" ne postoji.");
        }
        driver.quit();
    }
}