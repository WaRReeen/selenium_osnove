package p28_09_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static java.util.concurrent.TimeUnit.SECONDS;

public class TestHelper {
    private WebDriver driver;
    public TestHelper(WebDriver driver) {
        this.driver = driver;
    }
    public boolean elementExists(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
    public boolean elementExistsByList(By by) {
        return !driver.findElements(by).isEmpty();
    }
    public void setDefaultImplicitWait() {
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
    }
    public void setImplicitWait(int seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, SECONDS);
    }
}
