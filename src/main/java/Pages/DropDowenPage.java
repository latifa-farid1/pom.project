package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DropDowenPage {
    WebDriver driver;
    By DropDowenField=By.id("dropdown");
    By option1=By.xpath("//option[text()='Option 1']");

    public DropDowenPage(WebDriver driver){
        this.driver=driver;
    }

    public String OpenDropDowen(String Text){
        driver.findElement(DropDowenField).click();
        driver.findElement(option1).click();
       return driver.findElement(option1).getText();
    }
}
