package de.uulm.sqa.algorithms;

import java.util.Vector;

/**
 * Singleton fibonaci generator with memorisation.
 */
public class Fibonacci {

  private static Fibonacci generator;
  private final Vector<Integer> fibonaccis;

  private Fibonacci() {
    fibonaccis = new Vector<Integer>();
    fibonaccis.add(0);
    fibonaccis.add(1);
  }

  /**
   * Returns the singleton fibonacci generator.
   */
  public static Fibonacci getGenerator() {
    if (generator == null) {
      generator = new Fibonacci();
    }
    return generator;
  }

  /**
   * Returns the nth fibonacci number. If nth is negative, treat it as a positive number.
   */
  public int get(int nth) {
    nth = Math.abs(nth); //convert nth to a positive number

    if (nth < fibonaccis.size()) {
      return fibonaccis.get(nth);
    }
    for (int i = fibonaccis.size() - 1; i < nth; i++) {
      int fib1 = fibonaccis.get(i);
      int fib0 = fibonaccis.get(i - 1);
      fibonaccis.add(fib1 + fib0);
    }
    return fibonaccis.get(nth);
  }
}
