package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class HomePage {

    private WebDriver driver;

    //loc for default values in this page
    private By addLoc = By.xpath("/html/body/div[2]/div/div[2]/ul/li[1]/a");
    private By listLoc = By.xpath("/html/body/div[2]/div/div[2]/ul/li[2]/a");
    private By findQuoteBoxLoc = By.id("search-quote");


    //Add Menu
    private By  quoteAddLoc = By.xpath("/html/body/div[2]/div/div[2]/ul/li[1]/ul/li[1]/a");
    private By leadAddLoc = By.xpath("/html/body/div[2]/div/div[2]/ul/li[1]/ul/li[2]/a");
    private By accountAddLoc = By.xpath("/html/body/div[2]/div/div[2]/ul/li[1]/ul/li[3]/a");
    private By installerAddLoc = By.xpath("/html/body/div[2]/div/div[2]/ul/li[1]/ul/li[4]/a");

    //List Menu
    private By quoteListLoc = By.xpath("/html/body/div[2]/div/div[2]/ul/li[2]/ul/li[1]/a");

    //Add quote page
    private By addDoorBtnLoc = By.xpath("/html/body/div[3]/div[2]/div[1]/div/fieldset/div/div/div[3]/div/button");
    private By standardDoorMenuLoc = By.id("add-door-btn");



    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public String getWindowTitle(){
        System.out.println(driver.getTitle());
        return driver.getTitle();
    }

    public String[] checkDefaultMenu(){
        String add_menu = driver.findElement(addLoc).getText();
        String list_menu = driver.findElement(listLoc).getText();
        return new String[]{add_menu,list_menu};
    }

    public boolean checkFindQuote(){
        Boolean findQuote = driver.findElement(findQuoteBoxLoc).isDisplayed();
        return findQuote;
    }

    public String[] checkAddMenu(){
        driver.findElement(addLoc).click();
        String quoteAdd = driver.findElement(quoteAddLoc).getText();
        String leadAdd = driver.findElement(leadAddLoc).getText();
        String accountAdd = driver.findElement(accountAddLoc).getText();
        String installerAdd = driver.findElement(installerAddLoc).getText();
        return new String[]{quoteAdd,leadAdd,accountAdd,installerAdd};
    }

    public SearchQuotePage goSearchQuote(){
        driver.findElement(listLoc).click();
        driver.findElement(quoteListLoc).click();
        return new SearchQuotePage(driver);
    }

    public AddQuotePage addQuotePage(){
        driver.findElement(addLoc).click();
        driver.findElement(quoteAddLoc).click();
        return new AddQuotePage(driver);
    }

    public void clickStandardDoorBtn(){
        driver.findElement(addDoorBtnLoc).click();
        driver.findElement(standardDoorMenuLoc).click();
    }

    public StandardDoor standardDoor() throws InterruptedException{
        driver.findElement(addLoc).click();
        driver.findElement(quoteAddLoc).click();
        clickStandardDoorBtn();
        driver.switchTo().window(driver.getWindowHandles().toArray()[driver.getWindowHandles().size()-1].toString());
        Thread.sleep(1500);
        return new StandardDoor(driver);
    }

    public AddStandardDoor addStandardDoor() throws InterruptedException{
        driver.findElement(addLoc).click();
        driver.findElement(quoteAddLoc).click();
//        String parentWindowHandle = driver.getWindowHandle();
        clickStandardDoorBtn();
        driver.switchTo().window(driver.getWindowHandles().toArray()[driver.getWindowHandles().size()-1].toString());
        Thread.sleep(1500);

//        Thread.sleep(1500);
//
//        Set<String> handles = driver.getWindowHandles();
//        for (String handle : handles){
//            driver.switchTo().window(handle);
//            if (driver.findElement(By.tagName("div")).getAttribute("id").equals("quickDoorAddModal")) {
////                // 切换到新打开的窗口
////                driver.switchTo().window(handle);
//                break; // 找到新窗口后退出循环
//            }
//        }


//        String newWindowsHandle = driver.getWindowHandles().toArray()[driver.getWindowHandles().size()-1].toString();
//        driver.switchTo().window(newWindowsHandle);
//        Set<String> handles = driver.getWindowHandles();

        return new AddStandardDoor(driver);
    }


}
