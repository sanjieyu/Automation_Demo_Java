package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private By usernamebox = By.xpath("//*[@id=\"Email\"]");
    private By passwordbox = By.xpath("//*[@id=\"Password\"]");

    private By login_btn = By.xpath("//*[@id=\"loginForm\"]/form/div[4]/div/input");

    public LoginPage(WebDriver driver){

        this.driver = driver;
    }

    public void setUsername(String username){

        driver.findElement(usernamebox).sendKeys(username);
    }

    public void setPassword(String password){
        driver.findElement(passwordbox).sendKeys(password);
    }

    public HomePage clickLogin(){
        driver.findElement(login_btn).click();
        return new HomePage(driver);
    }
}
