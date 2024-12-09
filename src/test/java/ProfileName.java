import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class ProfileName extends BaseTest{

    @Test
    public void changeProfileName() throws InterruptedException {
        provideEmail("aleksei.koksharov@testpro.io");
        providePassword("ak1234!@#$");
        clickSubmit();
        Thread.sleep(2000);
        clickAvatarIcon();
        String randomName = generateRandomName();
        provideCurrentPassword("ak1234!@#$");
        provideProfileName(randomName);
        clickSaveButton();
        Thread.sleep(2000);
        WebElement actualProfileName = driver.findElement(By.cssSelector("a.view-profile>span"));
        Assert.assertEquals(actualProfileName.getText(), randomName);
    }

    private void clickSaveButton() {
        WebElement saveButton = driver.findElement(By.cssSelector("button.btn-submit"));
        saveButton.click();
    }

    private void provideProfileName(String randomName) {
        WebElement profileName = driver.findElement(By.cssSelector("[name='name']"));
        profileName.clear();
        profileName.sendKeys(randomName);
    }

    private void provideCurrentPassword(String password) {
        WebElement currentPassword = driver.findElement(By.cssSelector("[name='current_password']"));
        currentPassword.clear();
        currentPassword.sendKeys(password);
    }

    private String generateRandomName() {
        return UUID.randomUUID().toString().replace("-","");
    }

    private void clickAvatarIcon() {
        WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
        avatarIcon.click();
    }
}
