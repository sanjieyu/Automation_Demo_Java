package base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchQuotePage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BaseTests {

    private WebDriver driver;
    public LoginPage loginPage;
    public HomePage homePage; // 将 homePage 声明为类的成员变量

    public SearchQuotePage searchQuotePage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://egd2.sighte.com");
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        loginPage.setUsername("ysun@ecogaragedoors.com.au");
        loginPage.setPassword("Tims@123");
        homePage = loginPage.clickLogin();  // 使用类的成员变量赋值
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @AfterMethod
    public void recordFailure(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus())
        {
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try{
                Path destination = Paths.get("resources/screenshots/" + result.getName() + ".png");
                Files.move(screenshot.toPath(),destination);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

//    public static void main(String args[]){
//        BaseTests test = new BaseTests();
//        test.setUp();
//    }
}
