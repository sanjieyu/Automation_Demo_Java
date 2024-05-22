package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.StandardDoor;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertListNotContains;

public class StandardDoorTest extends BaseTests {

    @Test
    public void testDoorPage() throws InterruptedException{
        StandardDoor standardDoor = homePage.standardDoor();
        assertEquals(standardDoor.checkDoorPage(),"Standard Door Details");
    }

    @Test
    public void testInstallDetails() throws InterruptedException{
        StandardDoor standardDoor = homePage.standardDoor();
        String[] expectedDetails = {"Install Type","Door Type"};
        assertEquals(standardDoor.checkInstallDetails(),expectedDetails);
    }

    @Test
    public void testInstallTypeList() throws InterruptedException{
        StandardDoor standardDoor = homePage.standardDoor();
        assertEquals(standardDoor.checkInstallType(), """
                Please Select
                Commercial Cat 1
                Commercial Cat 2
                Commercial STD
                Panel Replacement
                Residential""");
    }
}
