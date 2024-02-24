import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCalculatorFactorial {
    @Test
    public void testFactorialZero() {
        Assert.assertEquals(Calculator.factorial(0), 1);
    }

    @Test
    public void testFactorialOne() {
        Assert.assertEquals(Calculator.factorial(1), 1);
    }

    @Test
    public void testFactorialPositive() {
        Assert.assertEquals(Calculator.factorial(23), 8128291617894825984L);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialNegative() {
        Calculator.factorial(-1);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialOverflow() {
        Calculator.factorial(24);
    }
}
