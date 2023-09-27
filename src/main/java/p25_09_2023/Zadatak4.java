package p25_09_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak4 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/webtables");

        driver.findElement(By.xpath("//*[@id=\"edit-record-1\"]")).click();

        driver.findElement(By.id("firstName")).clear();
        driver.findElement(By.id("firstName")).sendKeys("NovoIme");

        driver.findElement(By.id("lastName")).clear();
        driver.findElement(By.id("lastName")).sendKeys("NovoPrezime");

        driver.findElement(By.id("userEmail")).clear();
        driver.findElement(By.id("userEmail")).sendKeys("novimail@gmail.com");

        driver.findElement(By.id("age")).clear();
        driver.findElement(By.id("age")).sendKeys("33");

        driver.findElement(By.id("salary")).clear();
        driver.findElement(By.id("salary")).sendKeys("123440");

        driver.findElement(By.id("department")).clear();
        driver.findElement(By.id("department")).sendKeys("odsek");

        driver.findElement(By.id("submit")).click();

        Thread.sleep(2000);

        driver.quit();
    }
}