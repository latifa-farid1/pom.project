package PagesTask2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

public class SearchPage {
    WebDriver driver;
    By searchValue ;
    By CheckBoxField=By.xpath("//input[@type='checkbox'][1]");
    By CheckBoxField1=By.xpath("//input[@type='checkbox'][2]");
    By uploadButton=By.xpath("//form[@method='POST']//input[@id='file-upload']");
    By ubloadFile=By.xpath("//input[@id='file-submit']");

    public SearchPage(WebDriver driver){
        this.driver=driver;
    }

    public String SearchlinkValue(int index){
      searchValue=By.xpath("(//article)["+index+"]//h2/a");
      return driver.findElement(searchValue).getAttribute("href");


    }
    public String SearchTextValue(int index){
        searchValue=By.xpath("(//article)["+index+"]//h2/a");
        return driver.findElement(searchValue).getText();
    }
    public String searchSeondResult(int index) {
    searchValue = By.xpath("(//article)[" + index + "]//h2/a");
    String linktext=  driver.findElement(searchValue).getAttribute("href");
    driver.findElement(searchValue).click();
     return linktext;
}
  public boolean CheckBoxMethod(){
    driver.navigate().to("http://the-internet.herokuapp.com/checkboxes");
    driver.findElement(CheckBoxField).click();
   return(driver.findElement(CheckBoxField).isSelected()&&driver.findElement(CheckBoxField1).isSelected());

}
  public void UploadFile(){
        driver.navigate().to("http://the-internet.herokuapp.com/upload");
        driver.findElement(ubloadFile).click();


}

}
