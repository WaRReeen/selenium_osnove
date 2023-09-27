package d26_09_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Scanner;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Unesite svoje ime: ");
        String firstName = scanner.nextLine();
        WebElement firstNameField = driver.findElement(By.id("firstName"));
        firstNameField.sendKeys(firstName);

        System.out.print("Unesite svoje prezime: ");
        String lastName = scanner.nextLine();
        WebElement lastNameField = driver.findElement(By.id("lastName"));
        lastNameField.sendKeys(lastName);

        System.out.print("Unesite svoju email adresu: ");
        String email = scanner.nextLine();
        WebElement emailField = driver.findElement(By.id("userEmail"));
        emailField.sendKeys(email);

        System.out.print("Unesite svoj broj mobilnog telefona: ");
        String mobileNumber = scanner.nextLine();
        WebElement mobileNumberField = driver.findElement(By.id("userNumber"));
        mobileNumberField.sendKeys(mobileNumber);

        System.out.print("Unesite svoju adresu: ");
        String currentAddress = scanner.nextLine();
        WebElement currentAddressField = driver.findElement(By.id("currentAddress"));
        currentAddressField.sendKeys(currentAddress);


        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        driver.quit();
    }
}