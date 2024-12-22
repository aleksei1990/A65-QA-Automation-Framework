import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest{

    @Test
    public void playSong(){

        login("aleksei.koksharov@testpro.io", "ak1234!@#$");
        clickPlayNextSongBtn();
        clickPlayBtn();
        Assert.assertTrue(playingSoundBar());
    }
    @Test
    public void playSongWithRightClick(){
        login("aleksei.koksharov@testpro.io", "ak1234!@#$");
        clickAllSongsBtn();
        chooseFirstSong();
        Assert.assertTrue(playingSoundBar());
    }

    public void chooseFirstSong() {
       WebElement firstSong = waitUntilVisible(By.cssSelector(".song-item:nth-child(1)"));
        actions.contextClick(firstSong).perform();
       WebElement contextPlayBtn = waitUntilVisible(By.cssSelector(".playback"));
       contextPlayBtn.click();
    }

    public void clickAllSongsBtn() {
        WebElement allSongsBtn = waitUntilVisible(By.cssSelector(".songs"));
        allSongsBtn.click();
    }

    public boolean playingSoundBar(){
        WebElement soundBar = waitUntilVisible(By.cssSelector("div[data-testid='sound-bar-play']"));
        return soundBar.isDisplayed();
    }

    public void clickPlayBtn() {
        WebElement playBtn = waitUntilVisible(By.cssSelector("span[data-testid='play-btn']"));
        playBtn.click();
    }

    public void clickPlayNextSongBtn() {
        WebElement playNextSongBtn = waitUntilClickable(By.cssSelector("i[data-testid='play-next-btn']"));
        actions.moveToElement(playNextSongBtn).perform();
        playNextSongBtn.click();
    }
}
