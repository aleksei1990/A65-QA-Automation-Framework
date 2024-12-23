import org.example.LoginPage;
import org.example.SearchSongPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest{

    @Test
    public void addSongToPlayList() {

        LoginPage loginPage = new LoginPage(driver);
        SearchSongPage searchSongPage = new SearchSongPage(driver);

        String expectedMsg = "Added 1 song into \"Test Playlist for HW21.\"";
        loginPage.login();
        searchSongPage.findSong("dark");
        searchSongPage.viewAllBtn();
        searchSongPage.firstSong();
        searchSongPage.addToBtn();
        searchSongPage.chooseplaylist();
        Assert.assertTrue(searchSongPage.successMsg(expectedMsg).isDisplayed());
    }
//    public String getSuccessMsg(){
//        WebElement successMsg = waitUntilVisible(By.cssSelector("div.success.show"));
//        return successMsg.getText();
//    }
//
//    public void choosePlayList() {
//        WebElement playlist = waitUntilClickable(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'Test Playlist for HW21')]"));
//        playlist.click();
//    }
//
//    public void clickAddToBtn() {
//        WebElement addToBtn = waitUntilClickable(By.cssSelector("button.btn-add-to"));
//        addToBtn.click();
//    }
//
//    public void chooseFirstSong() {
//        WebElement firstSong = waitUntilClickable(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]"));
//        firstSong.click();
//    }
//
//    public void clickViewAllBtn() {
//        WebElement viewAllBtn = waitUntilClickable(By.cssSelector("button[data-test='view-all-songs-btn']"));
//        viewAllBtn.click();
//    }
//
//    public void searchSong(String name) {
//        WebElement song = waitUntilVisible(By.cssSelector("input[type='search']"));
//        song.sendKeys(name);
//    }
}
