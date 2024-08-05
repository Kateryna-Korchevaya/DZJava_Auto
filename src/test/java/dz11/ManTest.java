package dz11;

import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ManTest {

    @DataProvider(name = "agesForRetirement")
    public Object[][] provideAgesForRetirement() {
        return new Object[][] {
                {65, false},
                {66, true},
                {70, true},
                {50, false}
        };
    }

    @Test(dataProvider = "agesForRetirement")
    public void testIsRetired(int age, boolean expected) {
        Man man = new Man("John", "Doe", age);
        assertEquals(man.isRetired(), expected);
    }

    @DataProvider(name = "partnershipData")
    public Object[][] providePartnershipData() {
        return new Object[][] {
                {"Jane", "Smith", true},
                {"Anna", "Johnson", false}
        };
    }

    @Test(dataProvider = "partnershipData")
    public void testRegisterAndDeregisterPartnership(String womanFirstName, String womanLastName, boolean revertLastName) {
        Man man = new Man("John", "Doe", 40);
        Woman woman = new Woman(womanFirstName, womanLastName, 30);

        // Testing registerPartnership
        man.registerPartnership(woman);
        assertEquals(man.getPartner(), woman);
        assertEquals(woman.getPartner(), man);
        assertEquals(woman.getLastName(), man.getLastName());

        // Testing deregisterPartnership
        man.deregisterPartnership(revertLastName);
        assertNull(man.getPartner());
        assertNull(woman.getPartner());
        if (revertLastName) {
            assertEquals(woman.getLastName(), womanFirstName + " (reverted)");
        } else {
            assertEquals(woman.getLastName(), man.getLastName());
        }
    }
}
