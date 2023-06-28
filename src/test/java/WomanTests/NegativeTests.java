package WomanTests;

import dataproviders.TestDataProvider;
import org.example.Man;
import org.example.Woman;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class NegativeTests {

    Woman woman = new Woman("Hellen", "Smith", 50, false);
    SoftAssert softAssert = new SoftAssert();

    @Test(groups={"regression"}, dataProvider = "IsRetiredWomanNegative", dataProviderClass = TestDataProvider.class)
    public void testNegativeIsRetired(int age) {

        softAssert.assertFalse(woman.isRetired(age), woman.getFirstName() + " is retired, because she reach 60. She is " + woman.getAge());
        softAssert.assertAll();
    }

    @Test(groups={"regression"}, dataProvider = "PersonDataNegative", dataProviderClass = TestDataProvider.class)
    public void testNegativeRegisterPartner(Man man, Woman woman) {

        softAssert.assertEquals(woman.getPartner(), null, "Negative test failed. " + "The partner is: " + woman.getPartner() + ", but it should not be set.");
        softAssert.assertEquals(woman.getMarriageStatus(), false, "Negative test failed. Woman is still married");
        softAssert.assertAll();
    }

   @Test(groups={"regression"}, dataProvider = "PersonDataPositive", dataProviderClass = TestDataProvider.class)
    public void testNegativeDeregisterPartner(Man man, Woman woman) {

        woman.deregisterPartnership(false);
        woman.setPartner(man);

        softAssert.assertEquals(woman.getPartner(),  man, "Negative test failed. " + woman.getFirstName() + "'s partner changed after divorce, but it should not.");

        softAssert.assertAll();
    }

    @Test(groups={"regression"}, dataProvider = "ReturnToPreviousLastName", dataProviderClass = TestDataProvider.class)
    public void testNegativeReturnToPreviousLastName(boolean returnToPreviousLastName) {

        softAssert.assertEquals(woman.deregisterPartnership(returnToPreviousLastName), false, "Negative test failed. " + woman.getFirstName() + " is returned to the previous last name after divocre.");

        softAssert.assertAll();
    }
}
