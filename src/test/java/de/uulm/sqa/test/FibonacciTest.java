package de.uulm.sqa.test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import de.uulm.sqa.algorithms.Fibonacci;

import org.junit.Test;


/**
 * Tests for fibonacci implementation.
 */
public class FibonacciTest {

  @Test
  public void testFibonacciImplementation() {
    Fibonacci generator = Fibonacci.getGenerator();
    assertEquals(generator.get(0), 0);
    assertEquals(generator.get(1), 1);
    assertEquals(generator.get(2), 1);
    assertEquals(generator.get(3), 2);
    assertEquals(generator.get(4), 3);
    assertEquals(generator.get(5), 5);
    assertEquals(generator.get(10), 55);
    assertEquals(generator.get(20), 6765);
    assertEquals(generator.get(30), 832040);
    assertEquals(generator.get(40), 63245986);
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
