import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {

    @Test
    public void loginEmptyEmailPassword(){
        navigateToPage();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void loginValidEmailPassword() throws InterruptedException {
        navigateToPage();
        provideEmail("aleksei.koksharov@testpro.io");
        Thread.sleep(2000);
        providePassword("ak1234!@#$");
        clickSubmit();
        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatarIcon.isDisplayed());
    }

    @Test(enabled = false, description = "Test has been marked as skipped due to an ongoing issue")
    public void loginInvalidEmailValidPassword() throws InterruptedException {
        navigateToPage();
        Thread.sleep(2000); //Added a temporary Thread.sleep for demo purposes
        provideEmail("invalid@testpro.io");
        providePassword("ak1234!@#$");
        clickSubmit();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void loginValidEmailInvalidPassword() throws InterruptedException {
        navigateToPage();
        Thread.sleep(2000); //Added a temporary Thread.sleep for demo purposes
        provideEmail("aleksei.koksharov@testpro.io");
        providePassword("invalid");
        clickSubmit();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

}
