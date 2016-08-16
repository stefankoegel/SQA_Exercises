package de.uulm.sqa.test;


import de.uulm.sqa.algorithms.Fibonacci;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;


/**
 * Tests for fibonacci implementation.
 */
public class FibonacciTest {

  @Test
  public void testFibonacciImplementation() {
    Fibonacci generator = Fibonacci.getGenerator();
    //errors:
    // - expected as first argument, actual as second argument
    // - last assert: expected should be 102334155 because 63245986 is the 39th fibonacci number
    assertEquals(0, generator.get(0));
    assertEquals(1, generator.get(1));
    assertEquals(1, generator.get(2));
    assertEquals(2, generator.get(3));
    assertEquals(3, generator.get(4));
    assertEquals(5, generator.get(5));
    assertEquals(55, generator.get(10));
    assertEquals(6765, generator.get(20));
    assertEquals(832040, generator.get(30));
    assertEquals(102334155, generator.get(40));
  }

  @Test
  public void testIfSingleton() {
    Fibonacci gen1 = Fibonacci.getGenerator();
    Fibonacci gen2 = Fibonacci.getGenerator();
    assertSame(gen1, gen2);
    gen1.get(100);
    gen2.get(1000);
    Fibonacci gen3 = Fibonacci.getGenerator();
    assertSame(gen1, gen3);
    assertSame(gen2, gen3);
  }

  @Test
  public void testNumbersLessThanZero() {
    Fibonacci generator = Fibonacci.getGenerator();
    assertEquals(generator.get(-1), 1);
    assertEquals(generator.get(-10), 55);
    assertEquals(generator.get(-20), 6765);
  }
}
