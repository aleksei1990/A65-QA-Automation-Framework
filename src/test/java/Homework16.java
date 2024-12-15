import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16 extends BaseTest {

    @Test
    public void registrationNavigation() {

        WebElement registrationBtn = waitUntilClickable(By.cssSelector("a[href='registration']"));
        registrationBtn.click();
        String registrationLink = "https://qa.koel.app/registration";
        Assert.assertEquals(driver.getCurrentUrl(), registrationLink);
        driver.quit();
    }
}
