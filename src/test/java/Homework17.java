import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest{

    @Test
    public void addSongToPlayList() throws InterruptedException {
        String expectedMsg = "Added 1 song into \"Test Playlist for HW21.\"";
        provideEmail("aleksei.koksharov@testpro.io");
        providePassword("ak1234!@#$");
        clickSubmit();
        Thread.sleep(2000);
        searchSong("dark");
        Thread.sleep(2000);
        clickViewAllBtn();
        Thread.sleep(2000);
        chooseFirstSong();
        Thread.sleep(2000);
        clickAddToBtn();
        Thread.sleep(2000);
        choosePlayList();
        Thread.sleep(2000);
        Assert.assertEquals(getSuccessMsg(), expectedMsg);
    }
    private String getSuccessMsg(){
        WebElement successMsg = driver.findElement(By.cssSelector("div.success.show"));
        return successMsg.getText();
    }

    private void choosePlayList() {
        WebElement playlist = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'Test Playlist for HW21')]"));
        playlist.click();
    }

    private void clickAddToBtn() {
        WebElement addToBtn = driver.findElement(By.cssSelector("button.btn-add-to"));
        addToBtn.click();
    }

    private void chooseFirstSong() {
        WebElement firstSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]"));
        firstSong.click();
    }

    private void clickViewAllBtn() {
        WebElement viewAllBtn = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        viewAllBtn.click();
    }

    private void searchSong(String name) {
        WebElement song = driver.findElement(By.cssSelector("input[type='search']"));
        song.sendKeys(name);
    }
}
