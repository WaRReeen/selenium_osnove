package p26_09_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak6 {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://cms.demo.katalon.com/");
        driver.manage().window().maximize();

        WebElement menuButton = driver.findElement(By.cssSelector(".navbar-toggler"));
        if (menuButton.isDisplayed()) {
            System.out.println("Crno MENU dugme je vidljivo.");
        } else {
            System.out.println("Crno MENU dugme nije vidljivo.");
        }

        driver.manage().window().setSize(new Dimension(700, 700));

        if (menuButton.isDisplayed()) {
            System.out.println("Crno MENU dugme je i dalje vidljivo nakon promene veličine prozora.");
        } else {
            System.out.println("Crno MENU dugme nije vidljivo nakon promene veličine prozora.");
        }
        driver.quit();
    }
}
