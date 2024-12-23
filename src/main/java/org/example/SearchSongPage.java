package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchSongPage extends BasePage{
    public SearchSongPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    By searchSong = By.cssSelector("input[type='search']");
    By clickViewAllBtn = By.cssSelector("button[data-test='view-all-songs-btn']");
    By chooseFirstSong = By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]");
    By clickAddToBtn = By.cssSelector("button.btn-add-to");
    By choosePlayList = By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'Test Playlist for HW21')]");
    By getSuccessMsg = By.cssSelector("div.success.show");

    public void findSong(String name){
        findElement(searchSong).sendKeys(name);
    }
    public void viewAllBtn(){
        findElement(clickViewAllBtn).click();
    }
    public void firstSong(){
        findElement(chooseFirstSong).click();
    }
    public void addToBtn(){
        findElement(clickAddToBtn).click();
    }
    public void chooseplaylist(){
        findElement(choosePlayList).click();
    }
    public WebElement successMsg(String expectedMsg){
        return findElement(getSuccessMsg);
    }

}
