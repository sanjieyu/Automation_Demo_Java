package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchQuotePage;

import java.security.Provider;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SearchQuoteTest extends BaseTests {

    @Test
    public void testSearchQuoteTitle(){
        SearchQuotePage searchQuotePage = homePage.goSearchQuote();
        assertEquals(searchQuotePage.checkTitle(),"Search Quotes");
    }

    @Test
    public void testCheckDefaultSection(){
        SearchQuotePage searchQuotePage = homePage.goSearchQuote();
        assertTrue(searchQuotePage.checkDefaultSection());
    }

    @Test
    public void testCheckDefaultElements(){
        SearchQuotePage searchQuotePage = homePage.goSearchQuote();
        String[] expectedElements = {"Quotes","Doors","Search Results"};
        assertEquals(searchQuotePage.checkDefaultElements(),expectedElements);
    }

    @Test
    public void testCheckSectionQuotes(){
        SearchQuotePage searchQuotePage = homePage.goSearchQuote();
        String[] expectedSectionQuotes = {"Date Range","Client Details","Quote Information"};
        assertEquals(searchQuotePage.checkSectionQuotes(),expectedSectionQuotes);
    }

    @Test
    public void testCheckDateRange(){
        SearchQuotePage searchQuotePage = homePage.goSearchQuote();
        String[] expectedDateRange = {"Filter Date","User","Quote Status"};
        assertEquals(searchQuotePage.checkDateRange(),expectedDateRange);
    }

    @Test
    public void testCheckClientDetails(){
        SearchQuotePage searchQuotePage = homePage.goSearchQuote();
        String[] expectedDetails = {"Client Name","Contact Number","Suburb","Postcode"};
        assertEquals(searchQuotePage.checkClientDetails(),expectedDetails);
    }

    @Test
    public void testCheckDefaultUser(){
        SearchQuotePage searchQuotePage = homePage.goSearchQuote();
        assertEquals(searchQuotePage.checkDefaultUser(),"Yi Sun");
    }

    @Test
    public void testSearchClientName(){
        SearchQuotePage searchQuotePage = homePage.goSearchQuote();
        assertEquals(searchQuotePage.searchClientName(),"203541");
    }

    @Test
    public void testSearchProposalId(){
        SearchQuotePage searchQuotePage = homePage.goSearchQuote();
        assertEquals(searchQuotePage.searchProposalId(),"203541");
    }

    @Test
    public void testSearchDoorDesign(){
        SearchQuotePage searchQuotePage = homePage.goSearchQuote();
        assertEquals(searchQuotePage.searchDoorDesign(),"203773");
    }

    @Test
    public void testSearchDoorColour(){
        SearchQuotePage searchQuotePage1 = homePage.goSearchQuote();
        assertEquals(searchQuotePage1.searchDoorColour(),"203541");
    }
}
