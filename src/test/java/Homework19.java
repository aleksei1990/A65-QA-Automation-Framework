import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework19 extends BaseTest{

    @Test
    public void deletePlayList() throws InterruptedException {
        String expectedDeleteMsg = "Deleted playlist \"Playlist 78.\"";
        provideEmail("aleksei.koksharov@testpro.io");
        Thread.sleep(2000);
        providePassword("ak1234!@#$");
        clickSubmit();
        Thread.sleep(2000);
        choosePlayList();
        Thread.sleep(2000);
        removeSelectedPlayList();
        Thread.sleep(2000);
        Assert.assertEquals(succesMsg(), expectedDeleteMsg);
    }
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

    public void choosePlayList() {
        WebElement playList = driver.findElement(By.cssSelector("a[href='#!/playlist/97185']"));
        playList.click();
    }
}
