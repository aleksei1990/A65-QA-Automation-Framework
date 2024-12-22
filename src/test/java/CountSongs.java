import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CountSongs extends BaseTest {

    @Test
    public void countSongs() throws InterruptedException {
        login("aleksei.koksharov@testpro.io", "ak1234!@#$");
        WebElement allSongsBtn = waitUntilVisible(By.cssSelector(".songs"));
        allSongsBtn.click();
        Thread.sleep(2000);
        List<WebElement> songs = driver.findElements(By.cssSelector(".song-item"));
        int size = songs.size();
        System.out.println(size);

    }

    @Test
    public void countSongsName() throws InterruptedException {
        login("aleksei.koksharov@testpro.io", "ak1234!@#$");
        WebElement allSongsBtn = waitUntilVisible(By.cssSelector(".songs"));
        allSongsBtn.click();
        Thread.sleep(2000);
        List<WebElement> songs = driver.findElements(By.cssSelector(".song-item .title"));
        int size = songs.size();
        System.out.println(size);
        List<String> songNames = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            String name = songs.get(i).getText();
            songNames.add(name);
            }
            System.out.println(songNames);
            Assert.assertTrue(songNames.contains("Riqui-Riqui"));

    }
}
