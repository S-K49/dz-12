package GetterSetterTests;

import dataproviders.TestDataProvider;
import org.example.Man;
import org.example.Person;
import org.example.Woman;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PositiveTests {

    Woman woman = new Woman("Hellen", "Smith", 35, true);

    @Test(groups={"smoke"}, dataProvider = "PersonDataPositive", dataProviderClass = TestDataProvider.class)
    public void testGetters(Man man, Woman woman) {

        Assert.assertEquals(woman.getFirstName(), "Hellen", "First name was not returned");
        Assert.assertEquals(man.getLastName(), "Black", "Last name was not returned");
        Assert.assertEquals(man.getAge(), 65, "Age is not returned");
        Assert.assertEquals(woman.getPreviousLastName(), "Smith", "Previous name is not returned");
        Assert.assertEquals(woman.getMarriageStatus(), true, "Marriage Status is not returned");
    }

    @Test(groups={"smoke"})
    public void testSetFirstName() {

        woman.setFirstName("Galya");

        Assert.assertEquals(woman.getFirstName(), "Galya", "First name is not set");
    }


    @Test(groups={"smoke"})
    public void testSetLastName() {
        woman.setLastName("Last name");

        Assert.assertEquals(woman.getLastName(), "Last name", "Last name was not set");

    }

    @Test(groups={"smoke"})
    public void testSetAge() {
        woman.setAge(55);

        Assert.assertEquals(woman.getAge(), 55, "Age was not set");

    }

    @Test(groups={"smoke"}, dataProvider = "PersonDataPositive", dataProviderClass = TestDataProvider.class)
    public void testSetPartner(Man man, Woman woman) {
        man.setPartner(woman);

        Assert.assertEquals(man.getPartner(), woman, "Partner was not set");

    }
}
