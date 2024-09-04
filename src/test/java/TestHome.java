import Pages.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestHome {

        WebDriver driver;
        Wait<WebDriver> wait;
        String username = "admin";
        String password = "admin";
        HomePage homepage;
        BasicAuthPage basicAuthPage;
        DragDropPage dragDropPage;
        DropDowenPage dropDowenPage;
       TablesPage tablesPage;
        //AiFrame aiFrame;
        String Actual;



    @BeforeMethod
        public void BeforeMethod() {
            driver=new ChromeDriver();
            wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(3))
                    .pollingEvery(Duration.ofMillis(3000))
                    .ignoring(NotFoundException.class)
                    .ignoring(ElementNotInteractableException.class)
                    .ignoring(StaleElementReferenceException.class)
                    .ignoring(AssertionError.class);
            driver.manage().window().setPosition(new Point(0,0));
            driver.manage().window().setSize(new Dimension(1280,720));
            driver.navigate().to("https://the-internet.herokuapp.com/");

            homepage=new HomePage(driver);
            basicAuthPage=new BasicAuthPage(driver);
            dragDropPage=new DragDropPage(driver);
            dropDowenPage=new DropDowenPage(driver);
            tablesPage=new TablesPage(driver);
             //aiFrame=new AiFrame(driver);

        }

        @AfterTest
        public void AfterMethod(){
            driver.quit();
        }

        @Test
        public void TestAuthPopup(){

            wait.until(d -> {
                homepage.OpenAnyPageLink("'/basic_auth'");
                basicAuthPage.AuthPopup(username,password);
                return true;
            });
        }

        @Test
        public void TestDragDroup(){
            wait.until(d->{
                homepage.OpenAnyPageLink("'/drag_and_drop'");
                Assert.assertEquals(dragDropPage.DragDropPhoto(Actual),"A");
                return true;

            });
        }

        @Test
    public void TestDropdowenList(){
        wait.until(d->{
            homepage.OpenAnyPageLink("'/dropdown'");
            Assert.assertEquals(dropDowenPage.OpenDropDowen(Actual),"Option 1");
            return true;
        });

        }
        @Test
    public void TestTableData(){
        wait.until(d->{
            homepage.OpenAnyPageLink("'/tables'");
          Assert.assertEquals(tablesPage.SelectTableRowe(Actual),"jdoe@hotmail.com")  ;
       return true;
        });
        }
        @Test
    public void TestAiFram(){
        wait.until(d->{
            homepage.OpenAnyPageLink("'/tinymce'");
            //aiFrame.closeIfram();
         return true;
        });
        }
}
