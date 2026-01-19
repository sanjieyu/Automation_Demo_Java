package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.AddQuotePage;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class AddQuoteTest extends BaseTests {

    @Test
    public void testQuoteUrl(){
        AddQuotePage addQuotePage = homePage.addQuotePage();
        assertEquals(addQuotePage.checkURL(),"http://xxxx/Quote/Create");
    }

    @Test
    public void testQuoteTitle(){
        AddQuotePage addQuotePage = homePage.addQuotePage();
        assertEquals(addQuotePage.checkTitle(),"Site details");
    }

    @Test
    public void testQuoteSection(){
        AddQuotePage addQuotePage = homePage.addQuotePage();
        String[] expectedSectioin = {"Proposal Details","Contact Details","Site Details","Doors"};
        assertEquals(addQuotePage.checkDefaultSection(),expectedSectioin);
    }

    @Test
    public void testSaveBtn(){
        AddQuotePage addQuotePage = homePage.addQuotePage();
        assertTrue(addQuotePage.checkSaveBtn());
    }

    @Test
    public void testChangeToAccount(){
        AddQuotePage addQuotePage = homePage.addQuotePage();
        assertTrue(addQuotePage.checkChangeToAccount());
    }

    @Test
    public void testAddDoorMenu(){
        AddQuotePage addQuotePage = homePage.addQuotePage();
        String expectedString = "Standard\nCustom\nShutter";
//        List<String> expectedMenu = Arrays.asList(expectedString.split("\\n"));
//        List<String> actualMenu = getList():
        assertEquals(addQuotePage.checkAddoorMenu(),expectedString,"wrong menu");
    }

    @Test
    public void testValidation() throws InterruptedException{
        AddQuotePage addQuotePage = homePage.addQuotePage();
        String[] expectedError = {"Validation Errors","1. Please select Supply Type.","2. Please enter Client Email address."};
        assertEquals(addQuotePage.checkValidation(),expectedError);
    }


}

