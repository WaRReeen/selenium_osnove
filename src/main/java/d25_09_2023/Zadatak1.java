package d25_09_2023;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        Thread.sleep(3000);

        driver.findElement(By.cssSelector("input[placeholder = 'Username']")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[text()=' Login ']")).click();

        Thread.sleep(5000);

        driver.findElement(By.cssSelector(".oxd-main-menu-search input")).sendKeys("Me");
        driver.findElement(By.cssSelector(".oxd-main-menu li:nth-child(1)")).click();

        Thread.sleep(1000);

        driver.findElement(By.className("oxd-userdropdown")).click();
        driver.findElement(By.cssSelector(".oxd-userdropdown .oxd-dropdown-menu>li:last-child")).click();

        Thread.sleep(5000);
        driver.quit();
    }
}