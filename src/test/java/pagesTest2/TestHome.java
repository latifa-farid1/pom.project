package pagesTest2;

import PagesTask2.DragDropFilePage;
import PagesTask2.HomePage;
import PagesTask2.SearchPage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.google.common.util.concurrent.Futures.withTimeout;

public class TestHome {

    WebDriver driver;
    String Actual;
    Wait<WebDriver>Wait;
    HomePage homePage;
    SearchPage searchPage;
    DragDropFilePage dragDropFilePage;
    @BeforeMethod
    public void SetUp() {
        driver = new ChromeDriver();
        Wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(3))
                .pollingEvery(Duration.ofMillis(3000))
                .ignoring(NotFoundException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(StaleElementReferenceException.class);
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1280, 720));
        driver.navigate().to("https://duckduckgo.com/");
        homePage= new HomePage(driver);
        searchPage=new SearchPage(driver);
        dragDropFilePage=new DragDropFilePage(driver);
    }
@AfterMethod
public void Tiredowen(){
        driver.quit();
}


        @Test
        public void GetTitleMethod(){
        Wait.until(d->{
           Assert.assertEquals(homePage.GetDUCKPageTitle(),"DuckDuckGo — Privacy, simplified."); ;
           return true;
        });

}
      @Test
    public void checkLogoIsDisplayed(){
      Wait.until(d->{
          Assert.assertTrue(homePage.LogoIsdesiplayed());
     return true; });
    }

@Test
    public void FirstSearch(){
    homePage.SearchMethod("Selenium WebDriver");
    Wait.until(d->{
          Assert.assertEquals(searchPage.SearchlinkValue(1),"https://www.selenium.dev/documentation/webdriver/");
       return true; });

    }

    @Test
public void FourthResult(){
    homePage.SearchMethod("TestNG");
    Wait.until(d->{
        //assert with invalid value
        Assert.assertEquals(searchPage.SearchTextValue(4),"TestNG Tutorial");
        return true; });
}

@Test
    public void secondsearch(){
    homePage.SearchMethod("Cucumber IO");
    Wait.until(d->{
        Assert.assertTrue(searchPage.searchSeondResult(2).contains("https://cucumber.io"));
    return true;
    });
}

@Test
    public void checkbox(){
     Wait.until(d->{
        Assert.assertTrue(searchPage.CheckBoxMethod());
        return true;
     });
    }
    @Test
     public void uploadImage(){
         Wait.until(d->{
             searchPage.UploadFile();
             return true;
         });
    }
    @Test
    public void Dragdropufile(){
        Wait.until(d->{
            Assert.assertEquals(dragDropFilePage.DragDropmethod(Actual),"Dropped!");  ;
             return true;
                      });
                               }


}


