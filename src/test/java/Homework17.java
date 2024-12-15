import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest{

    @Test
    public void addSongToPlayList() {

        String expectedMsg = "Added 1 song into \"Test Playlist for HW21.\"";
        login("aleksei.koksharov@testpro.io", "ak1234!@#$");
        searchSong("dark");
        clickViewAllBtn();
        chooseFirstSong();
        clickAddToBtn();
        choosePlayList();
        Assert.assertEquals(getSuccessMsg(), expectedMsg);
    }
    public String getSuccessMsg(){
        WebElement successMsg = waitUntilVisible(By.cssSelector("div.success.show"));
        return successMsg.getText();
    }

    public void choosePlayList() {
        WebElement playlist = waitUntilClickable(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'Test Playlist for HW21')]"));
        playlist.click();
    }

    public void clickAddToBtn() {
        WebElement addToBtn = waitUntilClickable(By.cssSelector("button.btn-add-to"));
        addToBtn.click();
    }

    public void chooseFirstSong() {
        WebElement firstSong = waitUntilClickable(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]"));
        firstSong.click();
    }

    public void clickViewAllBtn() {
        WebElement viewAllBtn = waitUntilClickable(By.cssSelector("button[data-test='view-all-songs-btn']"));
        viewAllBtn.click();
    }

    public void searchSong(String name) {
        WebElement song = waitUntilVisible(By.cssSelector("input[type='search']"));
        song.sendKeys(name);
    }
}
