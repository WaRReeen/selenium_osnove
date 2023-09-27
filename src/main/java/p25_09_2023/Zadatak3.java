package p25_09_2023;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");

        String[] fullNames = {"Ratko Repic", "Pera Peric", "Milan Milic"};
        String[] emails = {"ratko.nesto#gmail.com", "peraperici.svasta@gmail.com", "milan.kogdekako@gmail.com"};
        String[] currentAddresses = {"ulica 2, Novi Sad, Srbija", "ulica 23, Novi Sad, Srbija", "ulica 12, Nis, Srbija"};
        String[] permanentAddresses = {"ulica 12, Novi Sad, Srbija", "ulica 72, Novi Sad, Srbija", "ulica 29, Novi Sad, Srbija"};

        for (int i = 0; i < 3; i++) {
            driver.findElement(By.id("userName")).sendKeys(fullNames[i]);
            driver.findElement(By.id("userEmail")).sendKeys(emails[i]);
            driver.findElement(By.id("currentAddress")).sendKeys(currentAddresses[i]);
            driver.findElement(By.id("permanentAddress")).sendKeys(permanentAddresses[i]);

            driver.findElement(By.xpath("//button[text()='Submit']")).click();

            Thread.sleep(2000);

            driver.navigate().refresh();
        }

        driver.quit();
    }
}
