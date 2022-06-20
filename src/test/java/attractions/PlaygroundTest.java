package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.*;

public class PlaygroundTest {
    Playground playground;
    Visitor visitor;

    @Before
    public void setUp() throws Exception {
        playground = new Playground("Fun Zone", 7);
    }

    @Test
    public void hasName() {
        assertEquals("Fun Zone", playground.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(7, playground.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, playground.getVisitCount());
    }

    @Test
    public void isAllowedIfUnder15(){
        visitor = new Visitor(10, 1.1, 10);
        assertTrue(playground.isAllowedTo(visitor));
    }

    @Test
    public void isNotAllowedIfOver15(){
        visitor = new Visitor(17, 1.4, 30);
        assertFalse(playground.isAllowedTo(visitor));
    }
}
