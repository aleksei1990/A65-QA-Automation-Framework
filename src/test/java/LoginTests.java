import org.example.HomePage;
import org.example.LoginPage;
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
    public void loginValidEmailPassword() {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();
//        login("aleksei.koksharov@testpro.io", "ak1234!@#$");
//        WebElement avatarIcon = waitUntilVisible(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    @Test(enabled = false, description = "Test has been marked as skipped due to an ongoing issue")
    public void loginInvalidEmailValidPassword() {

        login("invalid@testpro.io", "ak1234!@#$");
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void loginValidEmailInvalidPassword() {

        login("aleksei.koksharov@testpro.io", "invalid");
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
