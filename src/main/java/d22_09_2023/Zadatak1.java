package d22_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {
        public static void main(String[] args) throws InterruptedException {

            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();

            String[] urls = {
                    "https://www.google.com/",
                    "https://www.facebook.com/",
                    "https://www.youtube.com/",
                    "https://www.ebay.com/",
                    "https://www.katalon.com/"
            };

            for (int i = 0; i < urls.length; i++) {
                String url = urls[i];
                driver.get(url);
                Thread.sleep(2000);
            }

            driver.quit();
        }
    }
