import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework19 extends BaseTest{

    @Test
    public void deletePlayList() throws InterruptedException {

        String expectedDeleteMsg = "Deleted playlist \"Playlist 78.\"";
        String playListName = "Playlist 78";
        login("aleksei.koksharov@testpro.io", "ak1234!@#$");
//        createPlayList(playListName);
        Thread.sleep(2000);
        choosePlayList(playListName);
        removeSelectedPlayList();
        Assert.assertEquals(succesMsg(), expectedDeleteMsg);
    }

//    public void createPlayList(String playListName) {
//        actions.moveToElement(playList()).perform();
//        WebElement crtNewPlayListBtn = waitUntilClickable(By.cssSelector("ul>li[data-testid='playlist-context-menu-create-simple']"));
//        crtNewPlayListBtn.click();
//        crtNewPlayListBtn.sendKeys(playListName);
//        crtNewPlayListBtn.sendKeys(Keys.ENTER);
//
//    }
//
//    public WebElement playList() {
//        WebElement playList = waitUntilClickable(By.cssSelector("i[class='fa fa-plus-circle create']"));
//        playList.click();
//        return playList;
//    }

    public String succesMsg(){
        WebElement msg = driver.findElement(By.cssSelector("div.success.show"));
        return msg.getText();
    }

    public void removeSelectedPlayList() {
        WebElement selectedPlayList = driver.findElement(By.cssSelector("button[class='del btn-delete-playlist']"));
        selectedPlayList.click();
        WebElement okBtn = driver.findElement(By.cssSelector("button.ok"));
        okBtn.click();
    }

    public void choosePlayList(String playListName) {
        WebElement playList = driver.findElement(By.cssSelector("a[href='#!/playlist/97185']"));
        playList.click();
    }
}
