package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;

public class AddQuotePage {
    private WebDriver driver;

    //loc for each section in this page
    private By proposalDetailsLoc = By.xpath("/html/body/div[3]/div[2]/div[1]/div/form/div/h1[1]");
    private By contactDetailsLoc = By.xpath("/html/body/div[3]/div[2]/div[1]/div/form/div/h1[2]");
    private By siteDetailsLoc = By.xpath("/html/body/div[3]/div[2]/div[1]/div/form/div/h1[3]");
    private By doorsLoc = By.xpath("/html/body/div[3]/div[2]/div[1]/div/fieldset/h1");
    private By saveQuoteBtn = By.id("btnSaveQuote");
    private By addDoorBtnLoc = By.xpath("/html/body/div[3]/div[2]/div[1]/div/fieldset/div/div/div[3]/" +
            "div/button");
    private By addDoorMenuLoc = By.className("dropdown-menu");


    // loc for each element in "Proposal Details" section
    private By accountTypeSelectLoc = By.id("PaymentTypeId");
    private By accoutCustomerSelectLoc = By.xpath("//*[@id=\"accountCustomerData\"]/div/div[1]/span");

    //loc for Valication page
    private By validationErrorLoc = By.xpath("/html/body/div[3]/div[2]/div[7]/div/div/div[1]/h4");
    private By validationErrorLoc1 = By.xpath("/html/body/div[3]/div[2]/div[7]/div/div/div[1]/div[1]/ul/li[1]");
    private By validationErrorLoc2 = By.xpath("/html/body/div[3]/div[2]/div[7]/div/div/div[1]/div[1]/ul/li[2]");
    private By validationBtnLoc = By.id("btnCommentAdd");


    public AddQuotePage(WebDriver driver){
        this.driver = driver;
    }

    public String checkURL(){
        String quoteUrl = driver.getCurrentUrl();
        return quoteUrl;
    }

    public String checkTitle(){
        String quoteTitle = driver.getTitle();
        return quoteTitle;
    }

    public String[] checkDefaultSection(){
        String proposalDetails = driver.findElement(proposalDetailsLoc).getText();
        String contactDetails = driver.findElement(contactDetailsLoc).getText();
        String siteDetails = driver.findElement(siteDetailsLoc).getText();
        String doors = driver.findElement(doorsLoc).getText();
        return new String[]{proposalDetails,contactDetails,siteDetails,doors};
    }

    public boolean checkSaveBtn(){
        try{
            driver.findElement(saveQuoteBtn);  //check button在不在
            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }

    public boolean checkChangeToAccount(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(accountTypeSelectLoc).click();
        Select accountTypeSelect = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(accountTypeSelectLoc)));
        accountTypeSelect.selectByVisibleText("Account");
        wait.until(ExpectedConditions.visibilityOfElementLocated(accoutCustomerSelectLoc));
        boolean accountCustomerDropdown = driver.findElement(accoutCustomerSelectLoc).isEnabled();
        if(accountCustomerDropdown){
            return true;
        }else {
            return false;
        }
    }

    public String checkAddoorMenu(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");  // 滚动页面到底部
        driver.findElement(addDoorBtnLoc).click();
        WebElement addDoorMenu = driver.findElement(addDoorMenuLoc);
        List<WebElement> menuElement = addDoorMenu.findElements(By.xpath("/html/body/div[3]/div[2]/div[1]/div/fieldset/div/div/div[3]/div/ul"));
        List<String> doorItem = new ArrayList<>();     // 存储菜单项文本的列表
        for(WebElement item : menuElement){
            doorItem.add(item.getText());  // 获取菜单项文本并添加到列表中
        }
        String doorItems = String.join(",",doorItem);   // 将菜单项文本列表连接成一个字符串，以逗号分隔
        System.out.println(doorItem);
        return doorItems;
    }

    public String[] checkValidation() throws InterruptedException {
        driver.findElement(saveQuoteBtn).click();
        Thread.sleep(1500);     //用sleep一定要用try，catch或者方法名后加throws InterruptedException，
        driver.switchTo().window(driver.getWindowHandles().toArray()[driver.getWindowHandles().size()-1].toString());  //switch windows
        Thread.sleep(1500);
        String validationError = driver.findElement(validationErrorLoc).getText();
        String validationError1 = driver.findElement(validationErrorLoc1).getText();
        String validationError2 = driver.findElement(validationErrorLoc2).getText();
        driver.findElement(validationBtnLoc).click();
        return new String[]{validationError,validationError1,validationError2};
    }

}
