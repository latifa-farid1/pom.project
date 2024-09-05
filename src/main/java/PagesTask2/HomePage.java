package PagesTask2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;
    By SearchField= By.name("q");
    By logoElement=By.xpath("//section[not(contains(@class,'shrink'))]/a[@title='Learn about DuckDuckGo']");
    public HomePage(WebDriver driver){
        this.driver=driver;
    }

    public String SearchMethod(String searchtext){
       driver.findElement(SearchField).sendKeys(searchtext, Keys.ENTER);
       driver.findElement(SearchField).isDisplayed();
        return searchtext;
    }
    public String GetDUCKPageTitle(){
       return driver.getTitle();

    }
    public boolean LogoIsdesiplayed(){
   return driver.findElement(logoElement).isDisplayed();
    }
}
