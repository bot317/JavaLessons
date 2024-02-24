import org.junit.jupiter.api.Test;
import static junit.framework.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestCalculatorFactorial {
    @Test
    void testFactorialZero() {
        assertEquals(1, Calculator.factorial(0));
    }

    @Test
    void testFactorialOne() {
        assertEquals(1, Calculator.factorial(1));
    }

    @Test
    void testFactorialPositive() {
        assertEquals(8128291617894825984L, Calculator.factorial(23));
    }
    @Test
    void testFactorialNegative() {
        assertThrows(IllegalArgumentException.class, () -> Calculator.factorial(-1));
    }
    @Test
    void testFactorialOverflow() {
        assertThrows(IllegalArgumentException.class, () -> Calculator.factorial(24));
    }




}
