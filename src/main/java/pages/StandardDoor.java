package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StandardDoor {
    private WebDriver driver;

    public StandardDoor(WebDriver driver){
        this.driver = driver;
    }

    private By doorMainPageLoc = By.xpath("/html/body/div[3]/div[2]/div[2]/div/div/div/form");

    //loc for each element for install details
    private By titleLoc = By.xpath("/html/body/div[3]/div[2]/div[2]/div/div/div/form/h1");
    private By installTypeLoc = By.xpath("/html/body/div[3]/div[2]/div[2]/div/div/div/form/div[1]/div[4]/div[1]/fieldset/label");
    private By installTypeSelectLoc = By.id("InstallTypeStandard");
    private By doorTypeLoc = By.xpath("/html/body/div[3]/div[2]/div[2]/div/div/div/form/div[1]/div[4]/div[2]/fieldset/label");
//    private By addStandardDoorBtnLoc = By.id("btnDoorAdd");

    public String checkDoorPage(){
        WebElement formElement = driver.findElement(doorMainPageLoc);
        String standardDoorTitle = driver.findElement(titleLoc).getText();
        System.out.println(standardDoorTitle);
        return standardDoorTitle;
    }

    public String[] checkInstallDetails(){
        String installType = driver.findElement(installTypeLoc).getText();
        String doorType = driver.findElement(doorTypeLoc).getText();
        return new String[]{installType,doorType};
    }

    public String checkInstallType(){
        driver.findElement(installTypeSelectLoc).click();
        String installTypeList = driver.findElement(installTypeSelectLoc).getText();
        return installTypeList;
    }


}
