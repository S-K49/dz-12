package dataproviders;
import org.example.Man;
import org.example.Person;
import org.example.Woman;
import org.testng.annotations.DataProvider;

public class TestDataProvider {

    Man man = new Man("Garry", "Black", 65, true);
    Woman woman = new Woman("Hellen", "Smith", 60, true);

    Man man1 = new Man(null, null, 0, false);
    Woman woman1 = new Woman(null, null, 0, false);

        @DataProvider(name = "IsRetiredWomanPositive")
        public static Object[][] testIsRetiredWomanPositive() {
            return new Object[][] {{60},{61}};
    }

    @DataProvider(name = "IsRetiredManPositive")
    public static Object[][] testIsRetiredManPositive() {
        return new Object[][] {{65},{66}};
    }

    @DataProvider(name = "IsRetiredManNegative")
    public static Object[][] testIsRetiredManNegative() {
        return new Object[][] {{0},{64}};
    }

    @DataProvider(name = "IsRetiredWomanNegative")
    public static Object[][] testIsRetiredWomanNegative() {
        return new Object[][] {{0},{59}};
    }

    @DataProvider(name = "PersonDataPositive")
    public static Object[][] testPositiveRegisterPartner() {
        return new Object[][] {{new Man("Garry", "Black", 65, true), new Woman("Hellen", "Smith", 60, true)}};
    }

    @DataProvider(name = "PersonDataNegative")
    public static Object[][] testNegativeRegisterPartner() {

        return new Object[][] {{new Man(null, null, 0, false), new Woman(null, null, 0, false)}};
    }

    @DataProvider(name = "ReturnToPreviousLastName")
    public static Object[][] testReturnToPreviousLastName() {
        return new Object[][] {{false}};
    }

}
