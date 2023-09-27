package p26_09_2023;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak7 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://netoglasi.rs/");
        WebElement categoryList = driver.findElement(By.xpath("//*[@id=\"main\"]/app-classfield-list/ion-content/ion-grid/ion-row[1]/ion-col[1]/app-category-picker/ion-row/ion-col/ion-list"));
        List<WebElement> categoryElements = categoryList.findElements(By.tagName("ion-label"));

        for (int i = 0; i < categoryElements.size(); i++) {
            WebElement categoryElement = categoryElements.get(i);
            System.out.println("Naziv kategorije: " + categoryElement.getText());
        }
        WebElement firstCategory = categoryElements.get(0);
        if (firstCategory.getText().equals("Automobili")) {
            System.out.println("Kategorija \"Automobili\" je na prvom mestu.");
        } else {
            System.out.println("Kategorija \"Automobili\" nije na prvom mestu.");
        }
        firstCategory.click();
        categoryElements = categoryList.findElements(By.tagName("ion-label"));

        boolean isAutomobiliPresent = false;
        for (int i = 0; i < categoryElements.size(); i++) {
            WebElement categoryElement = categoryElements.get(i);
            if (categoryElement.getText().equals("Automobili")) {
                isAutomobiliPresent = true;
                break;
            }
        }
        if (!isAutomobiliPresent) {
            System.out.println("Kategorija \"Automobili\" je izbačena iz liste.");
        } else {
            System.out.println("Kategorija \"Automobili\" nije izbačena iz liste.");
        }
        driver.quit();
    }
}

