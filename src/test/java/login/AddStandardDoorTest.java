package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.AddStandardDoor;

import static org.testng.Assert.assertEquals;

public class AddStandardDoorTest extends BaseTests {

    @Test
    public void testValidation() throws InterruptedException{
        AddStandardDoor addStandardDoor = homePage.addStandardDoor();
        assertEquals(addStandardDoor.validationInput(),"Errors\nDoor type is required\nDoor design is required\nDoor finish is required\nDoor color is required\nPackaging Type must be selected.\nIf SR (left) is less than 89mm, LH Jamb should be minimum 90mm.\nIf SR (right) is less than 89mm, RH Jamb should be minimum 90mm.");
    }

    @Test
    public void testType() throws InterruptedException{
        AddStandardDoor addStandardDoor = homePage.addStandardDoor();
        assertEquals(addStandardDoor.checkType(),"Add");
    }
}
