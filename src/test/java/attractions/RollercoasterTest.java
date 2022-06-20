package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.*;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;
    Visitor visitor;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);

    }

    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void canRideIfTallAndOld(){
        visitor = new Visitor(24, 147, 50);
        assertTrue(rollerCoaster.isAllowedTo(visitor));
    }

    @Test
    public void canNotRideIfShortAndYoung(){
        visitor = new Visitor(12, 123, 25);
        assertFalse(rollerCoaster.isAllowedTo(visitor));
    }

    @Test
    public void paysDefaultIfNormalHeight(){
        visitor = new Visitor(16, 199, 40);
        assertEquals(8.40, rollerCoaster.priceFor(visitor), 0.0);
    }

    @Test
    public void paysDoubleIfVeryTall(){
        visitor = new Visitor(16, 250, 90);
        assertEquals(16.80, rollerCoaster.priceFor(visitor), 0.0);
    }


}
