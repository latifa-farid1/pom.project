package PagesTask2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class DragDropFilePage {
    WebDriver driver;
    By FromElement=By.id("draggable");
    By ToElement= By.id("droppable");
    public DragDropFilePage(WebDriver driver){
        this.driver=driver;
    }
    public String DragDropmethod(String TEXT){
        Actions builder=new Actions(driver);
        driver.navigate().to("https://jqueryui.com/resources/demos/droppable/default.html");
        Action dragAndDrop = builder.clickAndHold(driver.findElement(FromElement))
                .moveToElement(driver.findElement(ToElement))
                .release(driver.findElement(ToElement))
                .build();
        //Performing the drag and drop action
        dragAndDrop.perform();
        return(driver.findElement(ToElement).getText());

    }
}
