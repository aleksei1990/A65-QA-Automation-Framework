import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{

    @Test
    public void playSong() {

        login("aleksei.koksharov@testpro.io", "ak1234!@#$");
        clickPlayNextSongBtn();
        clickPlayBtn();
        Assert.assertTrue(playingSoundBar());
    }

    public boolean playingSoundBar(){
        WebElement soundBar = waitUntilVisible(By.cssSelector("div[data-testid='sound-bar-play']"));
        return soundBar.isDisplayed();
    }

    public void clickPlayBtn() {
        WebElement playBtn = waitUntilClickable(By.cssSelector("span[data-testid='play-btn']"));
        playBtn.click();
    }

    public void clickPlayNextSongBtn() {
        WebElement playNextSongBtn = waitUntilClickable(By.cssSelector("i[data-testid='play-next-btn']"));
        playNextSongBtn.click();
    }
}
