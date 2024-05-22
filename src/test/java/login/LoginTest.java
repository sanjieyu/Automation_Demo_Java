package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.HomePage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTests {

    @Test
    public void testSuccessfulLogin(){
//        loginPage.setUsername("abcd");
//        loginPage.setPassword("abcd");
//        HomePage homePage = loginPage.clickLogin();
        assertEquals(homePage.getWindowTitle(),"Eco Garage Doors","title is wrong");
    }

    @Test
    public void testDefaultmenu(){
//        HomePage homePage = loginPage.clickLogin();
        String[] expectedMenu = {"ADD","LIST"};
        System.out.println(homePage.checkDefaultMenu());
        assertEquals(homePage.checkDefaultMenu(),expectedMenu);
    }

    @Test
    public void testFindQuote(){
        assertTrue(homePage.checkFindQuote());
    }

    @Test
    public void testAddMenu(){
        String[] expectedAddMenu = {"Quote","Lead","Account Customer","Installer"};
        assertEquals(homePage.checkAddMenu(),expectedAddMenu);
    }
}
