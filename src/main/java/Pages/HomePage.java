package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;
    By pageLink;

    public HomePage(WebDriver driver){
        this.driver=driver;

    }
    public void OpenAnyPageLink(String value){
        pageLink=By.xpath("//a[@href="+value+"]");
        driver.findElement(pageLink).click();

    }

}
