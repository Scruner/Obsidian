package ru.vdv;

// Java Program Demonstrate adding
// elements to TransferQueue

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

class AddingElementsExample {

  public static void main(String[] args) throws Exception {

    // Initializing the queue
    TransferQueue<Integer> queue
        = new LinkedTransferQueue<Integer>();

    // Adding elements to this queue
    for (int i = 10; i <= 14; i++) {
      queue.add(i);
    }

    // Add the element using offer() method
    System.out.println("adding 15 "
        + queue.offer(15, 5, TimeUnit.SECONDS));

    // Adding elements to this queue
    for (int i = 16; i <= 20; i++) {
      queue.put(i);
    }

    // Printing the elements of the queue
    System.out.println(
        "The elements in the queue are:");
    for (Integer i : queue) {
      System.out.print(i + " ");
    }

    System.out.println();

    // create another queue to demonstrate transfer
    // method
    TransferQueue<String> g
        = new LinkedTransferQueue<String>();

    new Thread(new Runnable() {
      public void run() {
        try {
          System.out.println("Transferring"
              + " an element");

          // Transfer a String element
          // using transfer() method
          g.transfer("is a computer"
              + " science portal.");
          System.out.println(
              "Element "
                  + "transfer is complete");
        } catch (InterruptedException e1) {
          System.out.println(e1);
        } catch (NullPointerException e2) {
          System.out.println(e2);
        }
      }
    })
        .start();

    try {

      // Get the transferred element
      System.out.println("Geeks for Geeks "
          + g.take());
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}

//Output:
//adding 15 true
//The elements in the queue are:
//10 11 12 13 14 15 16 17 18 19 20
//Transferring an element
//Element transfer is complete
//Geeks for Geeks is a computer science portal.
