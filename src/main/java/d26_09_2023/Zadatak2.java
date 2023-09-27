package d26_09_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://s.bootsnipp.com/iframe/Dq2X");
        Thread.sleep(1000);

        List<WebElement> r = driver.findElements(By.xpath("//button[@type='button']"));

        for (int i = 0; i <r.size() ; i++) {
            int list = r.size();
            System.out.println(list);
            r.get(i).click();
            r = driver.findElements(By.xpath("//button[@type='button']"));

            Thread.sleep(1000);
        }

        driver.quit();

    }


}
