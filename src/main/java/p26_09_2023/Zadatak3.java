package p26_09_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;


public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://s.bootsnipp.com/iframe/z80en");
        Thread.sleep(5000);

        List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"lorem\"]/table/tbody/tr"));
        for (int i = 0; i < rows.size(); i++) {
            WebElement row = rows.get(i);
            List<WebElement> cells = row.findElements(By.tagName("td"));

            for (int j = 0; j < cells.size(); j++) {
                WebElement cell = cells.get(j);
                System.out.print(cell.getText() + "\t");
            }
        }
        Thread.sleep(5000);
        driver.quit();
    }
}
