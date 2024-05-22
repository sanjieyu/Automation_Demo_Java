package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

public class SearchQuotePage {
    private WebDriver driver;

    //loc for default values in this page
    private By searchQuoteTitle = By.xpath("/html/body/div[3]/div[2]/div/div/h1");
    private By searchQuoteBtnLoc = By.xpath("/html/body/div[3]/div[2]/div/div/div/form/div/div/div[1]/div/div[4]/div/input");
    private By quotesSubLoc = By.xpath("/html/body/div[3]/div[2]/div/div/div/form/ul/li[1]/a");
    private By doorSubLoc = By.xpath("/html/body/div[3]/div[2]/div/div/div/form/ul/li[2]/a");
    private By searchResultLoc = By.xpath("/html/body/div[3]/div[2]/div/div/div/div/div/h4");

    //loc for default values in "Quotes" section
    private By dateRangeLoc = By.xpath("/html/body/div[3]/div[2]/div/div/div/form/div/div/div[1]/div/div[1]/div[1]/h4");
    private By clientDetailsLoc = By.xpath("/html/body/div[3]/div[2]/div/div/div/form/div/div/div[1]/div/div[2]/div[1]/h4");
    private By quoteInfoLoc = By.xpath("/html/body/div[3]/div[2]/div/div/div/form/div/div/div[1]/div/div[3]/div[1]/h4");

    private By filterDateLoc = By.xpath("/html/body/div[3]/div[2]/div/div/div/form/div/div/div[1]/div/div[1]/div[2]/label");
    private By userLoc = By.xpath("/html/body/div[3]/div[2]/div/div/div/form/div/div/div[1]/div/div[1]/div[3]/label");
    private By userBoxLoc = By.xpath("//*[@id=\"UserAssignedId\"]");
    private By quoteStatusLoc = By.xpath("/html/body/div[3]/div[2]/div/div/div/form/div/div/div[1]/div/div[1]/div[4]/label");

    private By clientNameLoc = By.xpath("/html/body/div[3]/div[2]/div/div/div/form/div/div/div[1]/div/div[2]/div[2]/label");
    private By contactNumberLoc = By.xpath("/html/body/div[3]/div[2]/div/div/div/form/div/div/div[1]/div/div[2]/div[3]/label");
    private By suburbLoc = By.xpath("/html/body/div[3]/div[2]/div/div/div/form/div/div/div[1]/div/div[2]/div[4]/label");
    private By postcodeLoc = By.xpath("/html/body/div[3]/div[2]/div/div/div/form/div/div/div[1]/div/div[2]/div[5]/label");

    //Input box for each filter
    private By clientNameBoxLoc = By.id("ClientName");
    private By propoalNoBoxLoc = By.id("ProposalNo");
    private By contactNumBoxLoc = By.id("Contact_Number");
    private By suburbBoxLoc = By.id("Suburb");
    private By doorDesignSelectLoc = By.id("DoorDesign");
    private By doorColourSelectLoc = By.id("DoorColor");

    private By proposalNoSearchedLoc = By.xpath("/html/body/div[3]/div[2]/div/div/div/div/div/div/div/div/table/tbody/tr/td[2]/a");


    public SearchQuotePage(WebDriver drive){
        this.driver = drive;
    }
    public String checkTitle(){
        return driver.findElement(searchQuoteTitle).getText();
    }

    public boolean checkDefaultSection(){
        boolean searchQuoteBtn = driver.findElement(searchQuoteBtnLoc).isDisplayed();
        return searchQuoteBtn;
    }

    public String[] checkDefaultElements(){
        String quotesSub = driver.findElement(quotesSubLoc).getText();
        String doorsSub = driver.findElement(doorSubLoc).getText();
        String searchResult = driver.findElement(searchResultLoc).getText();
        return new String[]{quotesSub,doorsSub,searchResult};
    }

    public String[] checkSectionQuotes(){
        String dateRange = driver.findElement(dateRangeLoc).getText();
        String clientDetails = driver.findElement(clientDetailsLoc).getText();
        String quoteInfo = driver.findElement(quoteInfoLoc).getText();
        return new String[]{dateRange,clientDetails,quoteInfo};
    }

    public String[] checkDateRange(){
        String filteDate = driver.findElement(filterDateLoc).getText();
        String user = driver.findElement(userLoc).getText();
        String quoteStatus = driver.findElement(quoteStatusLoc).getText();
        return new String[]{filteDate,user,quoteStatus};
    }

    public String[] checkClientDetails(){
        String clientName = driver.findElement(clientNameLoc).getText();
        String contactNum = driver.findElement(contactNumberLoc).getText();
        String suburb = driver.findElement(suburbLoc).getText();
        String postcode = driver.findElement(postcodeLoc).getText();
        return new String[]{clientName,contactNum,suburb,postcode};
    }

    public String checkDefaultUser(){
        Select userDropDown = new Select(driver.findElement(userBoxLoc));
        String defaultUser = userDropDown.getFirstSelectedOption().getText();
        System.out.println(defaultUser);
        return defaultUser;
    }

    public String searchClientName(){
        driver.findElement(clientNameBoxLoc).sendKeys("Automation Test");
        driver.findElement(searchQuoteBtnLoc).click();
        String proposalNo = driver.findElement(proposalNoSearchedLoc).getText();
        driver.findElement(clientNameBoxLoc).clear();
        return proposalNo;
    }

    public String searchProposalId(){
        driver.findElement(propoalNoBoxLoc).sendKeys("203541");
        driver.findElement(searchQuoteBtnLoc).click();
        String proposalNo = driver.findElement(proposalNoSearchedLoc).getText();
        driver.findElement(propoalNoBoxLoc).clear();
        return proposalNo;
    }

    public String searchDoorDesign(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));    //wait
        Select doorDesignSelect = new Select(driver.findElement(doorDesignSelectLoc));
        doorDesignSelect.selectByVisibleText("Slimline");
        driver.findElement(searchQuoteBtnLoc).click();
        String proposalNo = driver.findElement(proposalNoSearchedLoc).getText();
        wait.until(ExpectedConditions.visibilityOfElementLocated(doorDesignSelectLoc));  //WAIT
        Select element = new Select(driver.findElement(doorDesignSelectLoc));
        element.selectByIndex(0);
        return proposalNo;
    }

    public String searchDoorColour(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        Select doorColourSelect = new Select(driver.findElement(doorColourSelectLoc));
        doorColourSelect.selectByVisibleText("Walnut");
        driver.findElement(searchQuoteBtnLoc).click();
        String proposalNo = driver.findElement(proposalNoSearchedLoc).getText();
        wait.until(ExpectedConditions.visibilityOfElementLocated(doorColourSelectLoc));
        Select element = new Select(driver.findElement(doorColourSelectLoc));
        element.selectByIndex(0);
        return proposalNo;
    }
}
