import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class unitTests {
    private PolishNotation pn;

    @Before
    public void setUp() {
        pn = new PolishNotation();
    }

    @Test
    public void testEquations() {
        assertEquals(3.0, pn.polishNotation("+ 1 2"), 1e-15);
        assertEquals(4.0, pn.polishNotation("* - 3 1 2"), 1e-15);
        assertEquals(-5.0, pn.polishNotation("-5"), 1e-15);
        assertEquals(3.33, pn.polishNotation("/ * + 4 1 2 3"), 1e-15);
    }
}
