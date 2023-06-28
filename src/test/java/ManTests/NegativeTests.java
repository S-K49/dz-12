package ManTests;

import dataproviders.TestDataProvider;
import org.example.Man;
import org.example.Woman;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class NegativeTests {
    SoftAssert softAssert = new SoftAssert();

    @Test(groups={"regression"}, dataProvider = "IsRetiredManNegative", dataProviderClass = TestDataProvider.class)
    public void testNegativeIsRetired(int age) {

       Man man = new Man("Garry", "Black", 0, false);

        softAssert.assertFalse(man.isRetired(age), "Negative test failed. " + man.getFirstName() + " is retired, because his age is " + man.getAge());

        softAssert.assertAll();
    }

    @Test(groups={"regression"}, dataProvider = "PersonDataNegative", dataProviderClass = TestDataProvider.class)
    public void testNegativeRegisterPartner(Man man, Woman woman) {

        softAssert.assertEquals(man.getPartner(), null, "Negative test failed. " + man.getPartner() + " is not empty.");
        softAssert.assertEquals(man.getMarriageStatus(), false, "Negative test failed. " + man.getFirstName() + " is still married.");

        softAssert.assertAll();
    }

    @Test(groups={"regression"}, dataProvider = "PersonDataPositive", dataProviderClass = TestDataProvider.class)
    public void testNegativeDeregisterPartner(Man man, Woman woman) {

        man.deregisterPartnership(false);
        man.setPartner(woman);

        softAssert.assertEquals(man.getPartner(),  woman, "Negative test failed. " + woman.getFirstName() + "'s partner changed after divorce, but it should not.");

        softAssert.assertAll();
    }
}

