package p26_09_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://s.bootsnipp.com/iframe/z80en");

        List<WebElement> firstColumnElements = driver.findElements(By.xpath("//*[@id=\"lorem\"]/table/tbody/tr[1]"));
        for (int i = 0; i < firstColumnElements.size(); i++) {
            WebElement element = firstColumnElements.get(i);
            String elementText = element.getText();
            System.out.println("Tekst elementa prvog reda: " + elementText);
        }

        Thread.sleep(1000);

        List<WebElement> firstRowElements = driver.findElements(By.xpath("//*[@id=\"lorem\"]/table/tbody/tr/td[1]"));
        for (int i = 0; i < firstRowElements.size(); i++) {
            WebElement element = firstRowElements.get(i);
            String elementText = element.getText();
            System.out.print("Tekst elementa prve kolone: " + elementText);
        }

        Thread.sleep(5000);

        driver.quit();
    }
}

