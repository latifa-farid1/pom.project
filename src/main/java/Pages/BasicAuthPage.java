package Pages;

import org.openqa.selenium.WebDriver;

public class BasicAuthPage {
    WebDriver driver;
    public BasicAuthPage(WebDriver driver){
        this.driver=driver;}

    public void AuthPopup(String username,String password){
        String URL = "https://" + username + ":" + password + "@the-internet.herokuapp.com/basic_auth";
        driver.navigate().to(URL);
    }
}
