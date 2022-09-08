package ru.vdv;

// Java Program to Illustrate CopyOnWriteArraySet Class

// Importing required classes

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

// Main class
class ConcurrentDemo extends Thread {

  static CopyOnWriteArraySet l
      = new CopyOnWriteArraySet();

  // Method
  public void run() {
    // Child thread trying to add
    // new element in the Set object
    l.add("D");
  }

  // Method 2
  // Main driver method
  public static void main(String[] args) {

    // Adding elements
    // using add() method
    l.add("A");
    l.add("B");
    l.add("C");

    // We create a child thread
    // that is going to modify
    // CopyOnWriteArraySet l.
    ConcurrentDemo t = new ConcurrentDemo();

    // Running the child thread
    // using start() method
    t.start();

    // Waiting for the thread to
    // add the element

    // Try block to check for exceptions
    try {

      Thread.sleep(2000);
    }

    // Catch block to handle exceptions
    catch (InterruptedException e) {

      // Print statement
      System.out.println(
          "child going to add element");
    }

    System.out.println(l);

    // Now we iterate through the
    // CopyOnWriteArraySet and we
    // wont get exception.
    Iterator itr = l.iterator();

    while (itr.hasNext()) {

      String s = (String) itr.next();
      System.out.println(s);

      if (s.equals("C")) {

        // Here we will get
        // RuntimeException
        itr.remove();
      }
    }
  }
}

//Output:
//[A, B, C, D]
//A
//B
//C
//Exception in thread "main" java.lang.UnsupportedOperationException
//	at java.base/java.util.concurrent.CopyOnWriteArrayList$COWIterator.remove(CopyOnWriteArrayList.java:1124)
//	at ru.vdv.ConcurrentDemo.main(ConcurrentDemo.java:75)
