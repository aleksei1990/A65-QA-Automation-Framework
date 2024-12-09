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
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void loginValidEmailPassword() throws InterruptedException {
        provideEmail("aleksei.koksharov@testpro.io");
        Thread.sleep(2000);
        providePassword("ak1234!@#$");
        clickSubmit();
        Thread.sleep(2000);
        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatarIcon.isDisplayed());
    }

    @Test(enabled = false, description = "Test has been marked as skipped due to an ongoing issue")
    public void loginInvalidEmailValidPassword() throws InterruptedException {
        Thread.sleep(2000);
        provideEmail("invalid@testpro.io");
        providePassword("ak1234!@#$");
        clickSubmit();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void loginValidEmailInvalidPassword() throws InterruptedException {
        Thread.sleep(2000);
        provideEmail("aleksei.koksharov@testpro.io");
        providePassword("invalid");
        clickSubmit();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
    @Test(dataProvider = "IncorrectLoginData", dataProviderClass = DataPorviderCredentials.class)
    public void loginWithInvalidCredentials(String email, String password) throws InterruptedException {
        provideEmail(email);
        providePassword(password);
        clickSubmit();
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }
}
