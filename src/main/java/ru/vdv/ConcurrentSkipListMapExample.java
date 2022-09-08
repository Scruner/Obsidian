package ru.vdv;

// Java Program to Demonstrate
// ConcurrentSkipListMap

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ConcurrentSkipListMapExample {

  public static void main(String[] args) {
// Creating objects of CountDownLatch class
    CountDownLatch cd1 = new CountDownLatch(5);
    CountDownLatch cd2 = new CountDownLatch(5);
    CountDownLatch cd3 = new CountDownLatch(5);
    CountDownLatch cd4 = new CountDownLatch(5);

    // Creating objects of ExecutorService class
    ExecutorService es
        = Executors.newFixedThreadPool(2);

    // Display message only for better readability
    System.out.println("Starting");

    // Executing the tasks
    es.execute(new MyThread(cd1, "A"));
    es.execute(new MyThread(cd2, "B"));
    es.execute(new MyThread(cd3, "C"));
    es.execute(new MyThread(cd4, "D"));

    // Try block to check for exceptions
    try {

      // Waiting for tasks to complete
      cd1.await();
      cd2.await();
      cd3.await();
      cd4.await();
    }

    // Catch block to handle exceptions
    catch (InterruptedException e) {

      System.out.println(e);
    }

    // Making all current executing threads to terminate
    es.shutdown();

    // Display message only for better readability
    System.out.println("Done");
  }
}

// Class 2
// Helper class
class MyThread implements Runnable {

  // Class data members
  String name;
  CountDownLatch latch;

  // Constructor
  MyThread(CountDownLatch latch, String name) {

    // this keyword refers to current instance itself
    this.name = name;
    this.latch = latch;

    new Thread(this);
  }

  // Method
  // Called automatically when thread is started
  public void run() {

    for (int i = 0; i < 5; i++) {
      System.out.println(name + ": " + i);
      latch.countDown();
    }
  }
}

//Output:
//Starting
//A: 0
//B: 0
//A: 1
//B: 1
//A: 2
//B: 2
//A: 3
//B: 3
//A: 4
//B: 4
//C: 0
//C: 1
//D: 0
//C: 2
//C: 3
//D: 1
//C: 4
//D: 2
//D: 3
//D: 4
//Done
