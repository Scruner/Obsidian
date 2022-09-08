package ru.vdv;

import java.util.concurrent.atomic.AtomicLong;

public class CounterAtomic {

  private AtomicLong counter = new AtomicLong();

  public void increment() {
    counter.incrementAndGet();
  }

  public long get() {
    return counter.get();
  }
}
