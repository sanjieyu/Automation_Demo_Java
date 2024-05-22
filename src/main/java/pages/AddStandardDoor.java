package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class AddStandardDoor{

    private WebDriver driver;

    public AddStandardDoor(WebDriver driver){
//        super(driver);
        this.driver = driver;
    }

    private final By validationMsgLoc = By.id("doorerrormsgs_body");
    private final By addStandardDoorBtnLoc = By.xpath("//*[@id=\"btnDoorAdd\"]");
    private final By newDoorPageLoc = By.id("quickDoorAddModalBody");

    public String validationInput() throws InterruptedException{
        WebElement newDoorPage = driver.findElement(newDoorPageLoc);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(false);",newDoorPage);  //移动到form的最下面
        driver.findElement(addStandardDoorBtnLoc).click();
        String msgError = driver.findElement(validationMsgLoc).getText();
        System.out.println(msgError);
        return msgError;
    }

    public String checkType(){
        String typeInstall = driver.findElement(addStandardDoorBtnLoc).getText();
        return typeInstall;
    }
}



