import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoverOver extends BaseTest{

    @Test
    public void clickSongWithHoverOver(){
        login("aleksei.koksharov@testpro.io", "ak1234!@#$");
        findFooterLogo();
        getPauseBtn();
        Assert.assertTrue(getPauseBtn().isDisplayed());
    }

    public void findFooterLogo() {
        WebElement footerLogo = waitUntilVisible(By.cssSelector(".side.player-controls"));
        actions.moveToElement(footerLogo).perform();
        WebElement playLogoBtn = waitUntilVisible(By.cssSelector("[data-testid='play-btn']"));
        playLogoBtn.click();
    }

    public WebElement getPauseBtn() {
        WebElement pauseBtn = waitUntilVisible(By.cssSelector("[title='Pause']"));
        return pauseBtn;
    }
}
