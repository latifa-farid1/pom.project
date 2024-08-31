import Pages.BasicAuthPage;
import Pages.DragDropPage;
import Pages.DropDowenPage;
import Pages.HomePage;
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
        String Actual;



    @BeforeMethod
        public void BeforeMethod() {
            driver=new ChromeDriver();
            wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(1000))
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

        }

        @AfterTest
        public void AfterMethod(){
            driver.quit();
        }

        @Test
        public void TestAuthPopup(){

            wait.until(d -> {
                homepage.OpenBasicAuthPage();
                basicAuthPage.AuthPopup(username,password);
                return true;
            });
        }

        @Test
        public void TestDragDroup(){
            wait.until(d->{
                homepage.OpenDragDrop();
                Assert.assertEquals(dragDropPage.DragDropPhoto(Actual),"A");
                return true;

            });
        }

        @Test
    public void TestDropdowenList(){
        wait.until(d->{
            homepage.OpenDropDowen();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Assert.assertEquals(dropDowenPage.OpenDropDowen(Actual),"Option 1");
            return true;
        });

        }
}
