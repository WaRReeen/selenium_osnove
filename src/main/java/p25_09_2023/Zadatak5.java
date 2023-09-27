package p25_09_2023;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak5 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String[] urls = {
                "https://google.com/",
                "https://youtube.com/",
                "https://www.ebay.com/",
                "https://www.kupujemprodajem.com/"
        };

        for (int i = 0; i < urls.length; i++) {
            String url = urls[i];

            driver.get(url);
            String pageTitle = driver.getTitle();
            System.out.println(pageTitle);
        }

        driver.quit();
    }
}


