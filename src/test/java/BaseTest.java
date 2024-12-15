import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;
    WebDriverWait wait;
    public Actions actions = null;

    String url = "https://qa.koel.app/";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchClass(String BaseURL){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        url = BaseURL;
        navigateToPage();
    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
    public void navigateToPage(){
        driver.get(url);
    }
    public void provideEmail(String email) {

        //               ------------- WebElement with Thread.sleep()--------------
//        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        //               ------------- WebElement with ExplicityWait-------------
//        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
        //        ------------------------------------------------------------------

        WebElement emailField = waitUntilVisible(By.cssSelector("input[type='email']"));
        emailField.click();
        emailField.clear();
        emailField.sendKeys(email);
    }
    public void providePassword(String password) {

//               ------------- WebElement with Thread.sleep()--------------
//        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
//               ------------- WebElement with ExplicityWait-------------
//        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
//        ------------------------------------------------------------------

        WebElement passwordField = waitUntilVisible(By.cssSelector("input[type='password']"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public void clickSubmit() {

//               ------------- WebElement with Thread.sleep()--------------
//        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
//               ------------- WebElement with ExplicityWait-------------
//        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable("button[type='submit']"));
        //        ------------------------------------------------------------------

        WebElement submitButton = waitUntilClickable(By.cssSelector("button[type='submit']"));
        submitButton.click();
    }
    public void login(String email, String password){
        provideEmail(email);
        providePassword(password);
        clickSubmit();
    }

//      ------------------- Example of Explicity Wait------------------------
    public WebElement waitUntilVisible(By element){
        return new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(element));
    }
    public WebElement waitUntilClickable(By element){
        return new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(element));
    }
//      -----------------------------------------------------------------------

}