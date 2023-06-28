package GetterSetterTests;

import dataproviders.TestDataProvider;
import org.example.Man;
import org.example.Woman;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class NegativeTests {
    //Man man = new Man(null, null, 0, false);
   // Woman woman = new Woman(null, null, 0, false);
    SoftAssert softAssert = new SoftAssert();
    @Test(groups={"smoke"}, dataProvider = "PersonDataNegative", dataProviderClass = TestDataProvider.class)
    public void testGetters(Man man, Woman woman) {

        softAssert.assertEquals(woman.getFirstName(), null, "First name should not be returned");
        softAssert.assertEquals(man.getLastName(), null, "Last name should not be returned");
        softAssert.assertEquals(man.getAge(), 0, "Age should return 0");
        softAssert.assertEquals(woman.getMarriageStatus(), false, "Marriage Status should mot be true");
        softAssert.assertEquals(man.getPartner(), null, "Partner should not be returned");

        softAssert.assertAll();
    }
}
