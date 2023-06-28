package WomanTests;

import dataproviders.TestDataProvider;
import org.example.Man;
import org.example.Person;
import org.example.Woman;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PositiveTests {


    //Man man = new Man("TGarry", "TBlack", 66, false);
   // Woman woman = new Woman("HTellen", "TSmith", 61, false);
    SoftAssert softAssert = new SoftAssert();


   @Test(dataProvider = "IsRetiredWomanPositive", dataProviderClass = TestDataProvider.class, groups={"regression"})
    public void testPositiveIsRetired(int age) {

        Woman woman = new Woman("Hellen", "Smith", 0, false);

        softAssert.assertTrue(woman.isRetired(age), woman.getFirstName() + " is not retired yet, because she did not reach 60 yet. She is " + woman.getAge());
        softAssert.assertAll();
    }

    @Test(groups={"regression"}, dataProvider = "PersonDataPositive", dataProviderClass = TestDataProvider.class)
    public void testPositiveRegisterPartner(Man man, Woman woman) {

        woman.registerPartnership(man);

        System.out.println(woman.getMarriageStatus());

        softAssert.assertEquals(woman.getPartner(), man, woman.getPartner() + " is not the same as expected.");
        softAssert.assertEquals(woman.getLastName(), man.getLastName(), "Woman's last name is not changed after marriage to " + man.getLastName());
        softAssert.assertEquals(woman.getMarriageStatus(), true, "Woman is not married yet");

        softAssert.assertAll();
    }


    @Test(groups={"regression"}, dataProvider = "PersonDataNegative", dataProviderClass = TestDataProvider.class)
    public void testPositiveDeregisterPartner(Man man, Woman woman) {

        woman.deregisterPartnership(true);

        softAssert.assertEquals(woman.getPartner(),  null, woman.getFirstName() + "'s partner is not changed after divorce");
        softAssert.assertEquals(woman.getLastName(), woman.getPreviousLastName(), woman.getFirstName() + " is not returned to the previous last name");
        softAssert.assertEquals(woman.getMarriageStatus(), false, "Woman is still married");

        softAssert.assertAll();
    }
}
