package dz11;

import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WomanTest {

    @DataProvider(name = "agesForRetirement")
    public Object[][] provideAgesForRetirement() {
        return new Object[][] {
                {60, false},
                {61, true},
                {70, true},
                {50, false}
        };
    }

    @Test(dataProvider = "agesForRetirement")
    public void testIsRetired(int age, boolean expected) {
        Woman woman = new Woman("Jane", "Doe", age);
        assertEquals(woman.isRetired(), expected);
    }

    @DataProvider(name = "partnershipData")
    public Object[][] providePartnershipData() {
        return new Object[][] {
                {"John", "Smith", true},
                {"Paul", "Johnson", false}
        };
    }

    @Test(dataProvider = "partnershipData")
    public void testRegisterAndDeregisterPartnership(String manFirstName, String manLastName, boolean revertLastName) {
        Woman woman = new Woman("Jane", "Doe", 30);
        Man man = new Man(manFirstName, manLastName, 40);

        // Testing registerPartnership
        woman.registerPartnership(man);
        assertEquals(woman.getPartner(), man);
        assertEquals(man.getPartner(), woman);
        assertEquals(woman.getLastName(), man.getLastName());

        // Testing deregisterPartnership
        woman.deregisterPartnership(revertLastName);
        assertNull(woman.getPartner());
        assertNull(man.getPartner());
        if (revertLastName) {
            assertEquals(woman.getLastName(), woman.getFirstName() + " (reverted)");
        } else {
            assertEquals(woman.getLastName(), man.getLastName());
        }
    }
}
