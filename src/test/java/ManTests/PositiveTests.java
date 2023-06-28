package ManTests;

import dataproviders.TestDataProvider;
import org.example.Man;
import org.example.Woman;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PositiveTests {
    SoftAssert softAssert = new SoftAssert();

   @Test(dataProvider = "IsRetiredManPositive", dataProviderClass = TestDataProvider.class, groups={"regression"})
    public void testPositiveIsRetired(int age) {

       Man man = new Man("Garry", "Black", 0, false);

        softAssert.assertTrue(man.isRetired(age), man.getFirstName() + " is not retired yet, because he did not reach 65 yet. He is " + man.getAge());

        softAssert.assertAll();
    }

    @Test(groups={"regression"}, dataProvider = "PersonDataPositive", dataProviderClass = TestDataProvider.class)
    public void testPositiveRegisterPartner(Man man, Woman woman) {

        man.registerPartnership(woman);

        softAssert.assertEquals(man.getPartner(), woman, man.getPartner() + " is not the same as expected.");
        softAssert.assertEquals(man.getMarriageStatus(), true, man.getFirstName() + " is not married yet.");

        softAssert.assertAll();
    }

   @Test(groups={"regression"}, dataProvider = "PersonDataNegative", dataProviderClass = TestDataProvider.class)
    public void testPositiveDeregisterPartner(Man man, Woman woman) {

        man.deregisterPartnership(false);

        softAssert.assertEquals(man.getPartner(),  null, man.getFirstName() + "'s partner is not changed after divorce");
        softAssert.assertEquals(man.getMarriageStatus(), false, man.getFirstName() + " is still has a married status after divorce.");

        softAssert.assertAll();
    }
}

