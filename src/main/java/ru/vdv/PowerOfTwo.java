package ru.vdv;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

class PowerOfTwo {

  private static AtomicReference<BigInteger> current = new AtomicReference<>(
      null);

  BigInteger next() {
    BigInteger recent, next;
    do {
      recent = current.get();
      next = (recent == null) ? BigInteger.valueOf(1) : recent.shiftLeft(1);
    } while (!current.compareAndSet(recent, next));
    return next;
  }

  public static void main(String[] args) {
    PowerOfTwo p = new PowerOfTwo();
    System.out.println(p.next());
  }
}

//Output:
//1
