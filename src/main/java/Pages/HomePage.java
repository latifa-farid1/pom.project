package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;
    By BasicAuthlink=By.xpath("//a[@href='/basic_auth']");
    By DragDropLink=By.xpath("//a[@href='/drag_and_drop']");
    By DropDowenLink=By.xpath("//a[@href='/dropdown']");

    public HomePage(WebDriver driver){
        this.driver=driver;

    }
    public void OpenBasicAuthPage(){
        driver.findElement(BasicAuthlink).click();
    }

    public void OpenDragDrop(){
        driver.findElement(DragDropLink).click();
    }
    public void OpenDropDowen(){
        driver.findElement(DropDowenLink).click();
    }
}
