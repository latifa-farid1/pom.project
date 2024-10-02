package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TablesPage {
    WebDriver driver;
    By TableID= By.xpath("(//tr[contains(.,'Doe')]/td[3])[1]");
    public TablesPage(WebDriver driver){
        this.driver=driver;
    }
    public String SelectTableRowe(String value){
       return driver.findElement(TableID).getText();
    }
}
