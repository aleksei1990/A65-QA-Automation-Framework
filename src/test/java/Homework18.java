import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{

    @Test
    public void playSong() throws InterruptedException {
        Thread.sleep(2000);
        provideEmail("aleksei.koksharov@testpro.io");
        Thread.sleep(2000);
        providePassword("ak1234!@#$");
        Thread.sleep(2000);
        clickSubmit();
        Thread.sleep(2000);
        clickPlayNextSongBtn();
        Thread.sleep(2000);
        clickPlayBtn();
        Thread.sleep(2000);
        Assert.assertTrue(playingSoundBar());
    }

    public boolean playingSoundBar(){
        WebElement soundBar = driver.findElement(By.cssSelector("div[data-testid='sound-bar-play']"));
        return soundBar.isDisplayed();
    }

    public void clickPlayBtn() {
        WebElement playBtn = driver.findElement(By.cssSelector("span[data-testid='play-btn']"));
        playBtn.click();
    }

    public void clickPlayNextSongBtn() {
        WebElement playNextSongBtn = driver.findElement(By.cssSelector("i[data-testid='play-next-btn']"));
        playNextSongBtn.click();
    }
}
