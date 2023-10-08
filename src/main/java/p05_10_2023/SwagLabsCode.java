package p05_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class SwagLabsCode {

        private WebDriver driver;
        private WebDriverWait wait;

        private WebStorage webStorage;
        String baseUrl = "https://www.saucedemo.com/ ";

        String userName;

        String password;


    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void beforMethod() {
        driver.manage().deleteAllCookies();
        driver.navigate().to("https://www.saucedemo.com/ ");
    }
    @Test(priority = 1)
    public void VerifyErrorIsDisplayedWhenUsernameIsMissing () {
        driver.findElement(By.id("login-button")).click();
        WebElement errorElement = driver.findElement(By.cssSelector("[data-test=\"error\"]"));
        Assert.assertEquals(errorElement.getText(), "Epic sadface: Username is required");
    }
    @Test(priority = 2)
    public void VerifyErrorIsDisplayedWhenPasswordIsMissing () {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("login-button")).click();
        WebElement errorElement = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
        Assert.assertEquals(errorElement.getText(),"Epic sadface: Password is required");
    }
    @Test(priority = 3)
    public void VerifyErrorIsDisplayedWhenCredentialsAreWrong () {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("invalidpassword");
        driver.findElement(By.id("login-button")).click();
        WebElement errorElement = driver.findElement(By.cssSelector("[data-test=\"error\"]"));
        Assert.assertEquals(errorElement.getText(),"Epic sadface: Username and password do not match any user in this service");
    }
    @Test(priority = 4)
    public void VerifyErrorIsDisplayWhenUserIsLocked () {
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        WebElement errorElement = driver.findElement(By.cssSelector("[data-test=\"error\"]"));
        Assert.assertEquals(errorElement.getText(),"Epic sadface: Sorry, this user has been locked out.");

    }
    @Test(priority = 5)
    public void VerifySuccessfulLogin() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        driver.findElement(By.id("react-burger-menu-btn")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("logout_sidebar_link")));

        WebElement logoutbutton = driver.findElement(By.id("logout_sidebar_link"));
        Assert.assertTrue(logoutbutton.isDisplayed());
        logoutbutton.click();
        Assert.assertTrue(driver.findElement(By.id("login-button")).isDisplayed());
    }

    @Test (priority = 6, retryAnalyzer = SwagLabsRetryClass.class)
    public void addingProductsToCart(){
        userName = "standard_user";
        password = "secret_sauce";

        driver.findElement(By.id("user-name")).clear();
        driver.findElement(By.id("user-name")).sendKeys(userName);

        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.id("login-button")).click();

        wait    .withMessage("Login should be redirected to inventory page")
                .until(ExpectedConditions.urlContains("/inventory.html"));

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        wait
                .withMessage("Remove button should be present")
                .until(ExpectedConditions.presenceOfElementLocated(By.id("remove-sauce-labs-backpack")));

        Assert.assertEquals(driver.findElement(By.cssSelector("span.shopping_cart_badge"))
                .getText(), "1", "Number of products in cart should be 1");
    }
    @Test (priority = 7, retryAnalyzer = SwagLabsRetryClass.class)
    public void viewingProductDetails(){
        userName = "standard_user";
        password = "secret_sauce";

        driver.findElement(By.id("user-name")).clear();
        driver.findElement(By.id("user-name")).sendKeys(userName);

        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.id("login-button")).click();

        wait    .withMessage("Login should be redirected to inventory page")
                .until(ExpectedConditions.urlContains("/inventory.html"));

        driver.findElement(By.id("item_4_title_link")).click();

        wait
                .withMessage("Product description should be present")
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".inventory_details_desc")));
        Assert.assertEquals(driver.findElement(By.cssSelector(".inventory_details_name"))
                .getText(), "Sauce Labs Backpack", "Product name should be:Sauce Labs Backpack");
        Assert.assertTrue(driver.findElement(By.cssSelector(".inventory_details_price"))
                .getText().contains("$"), "Price should be displayed");
        Assert.assertTrue(driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).isDisplayed()
                , "Add to cart button should be present");

    }
    @Test (priority = 8, retryAnalyzer = SwagLabsRetryClass.class)
    public void removingProductsFromCart(){
        userName = "standard_user";
        password = "secret_sauce";

        driver.findElement(By.id("user-name")).clear();
        driver.findElement(By.id("user-name")).sendKeys(userName);

        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.id("login-button")).click();

        wait    .withMessage("Login should be redirected to inventory page")
                .until(ExpectedConditions.urlContains("/inventory.html"));

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();


        Assert.assertEquals(driver.findElement(By.cssSelector("span.shopping_cart_badge"))
                .getText(), "1", "Number of products in cart should be 1");

        driver.findElement(By.cssSelector(".shopping_cart_link")).click();

        wait
                .withMessage("Product should be present in a cart")
                .until(ExpectedConditions.presenceOfElementLocated(By.id("item_4_title_link")));

        driver.findElement(By.id("remove-sauce-labs-backpack")).click();

        wait
                .withMessage("Product should be deleted from cart")
                .until(ExpectedConditions.invisibilityOfElementLocated(By.id("item_4_title_link")));

    }
    @Test (priority = 9, retryAnalyzer = SwagLabsRetryClass.class)
    public void productCheckout(){
        userName = "standard_user";
        password = "secret_sauce";
        String checkoutFirstName = "Pera";
        String checkoutLastName = "Peric";
        String checkoutZip = "18000";

        driver.findElement(By.id("user-name")).clear();
        driver.findElement(By.id("user-name")).sendKeys(userName);

        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.id("login-button")).click();

        wait    .withMessage("Login should be redirected to inventory page")
                .until(ExpectedConditions.urlContains("/inventory.html"));

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("span.shopping_cart_badge"))
                .getText(), "1", "Number of products in cart should be 1");

        driver.findElement(By.cssSelector(".shopping_cart_link")).click();

        wait
                .withMessage("Product should be present in a cart")
                .until(ExpectedConditions.presenceOfElementLocated(By.id("item_4_title_link")));

        driver.findElement(By.id("checkout")).click();

        driver.findElement(By.id("first-name")).sendKeys(checkoutFirstName);
        driver.findElement(By.id("last-name")).sendKeys(checkoutLastName);
        driver.findElement(By.id("postal-code")).sendKeys(checkoutZip);

        driver.findElement(By.id("continue")).click();


        Assert.assertEquals(driver.findElement(By.cssSelector(".inventory_item_name"))
                .getText(), "Sauce Labs Backpack", "Product name should be:Sauce Labs Backpack");
        Assert.assertEquals(driver.findElement(By.cssSelector(".cart_quantity"))
                .getText(), "1", "Quantity of item should be 1");
        Assert.assertTrue(driver.findElement(By.cssSelector(".inventory_item_price"))
                .getText().contains("$29.99"), "Price should be displayed");
        Assert.assertTrue(driver.findElement(By.cssSelector(".summary_tax_label"))
                .getText().contains("2.40"), "Total price should be 32.39");
        Assert.assertTrue(driver.findElement(By.cssSelector(".summary_total_label"))
                .getText().contains("32.39"), "Total price should be 32.39");

        driver.findElement(By.id("finish")).click();

        wait
                .withMessage("Check out should be completed with message:Thank you for your order!")
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#checkout_complete_container h2")))
                .getText().equals("Thank you for your order!");


    }
    @AfterMethod
    public void deleteWebStorageData(){
        webStorage = (WebStorage)driver;
        webStorage.getSessionStorage().clear();
        webStorage.getLocalStorage().clear();
    }
    @AfterClass
    public void closeDriver(){
        driver.quit();
    }
}
