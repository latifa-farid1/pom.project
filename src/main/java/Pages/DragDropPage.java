package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class DragDropPage {
    WebDriver driver;
    By fromEle= By.id("column-a");
    By toElement=By.id("column-b");
    public DragDropPage(WebDriver driver){
        this.driver=driver;}

    public String DragDropPhoto(String Text1){
        //Creating object of Actions class to build composite actions
        Actions builder=new Actions(driver);

        //Building a drag and drop action
        Action dragAndDrop = builder.clickAndHold(driver.findElement(fromEle))
                .moveToElement(driver.findElement(toElement))
                .release(driver.findElement(toElement))
                .build();
        //Performing the drag and drop action
        dragAndDrop.perform();
        return(driver.findElement(toElement).getText());

    }





}