package ru.vdv;

// Java Program Demonstrate TransferQueue

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class TransferQueueDemo {

  public static void main(String[] args)
      throws InterruptedException {
    // create object of TransferQueue
    // using LinkedTransferQueue() constructor
    TransferQueue<Integer> TQ
        = new LinkedTransferQueue<Integer>();

    // Add numbers to end of queue
    TQ.add(7855642);
    TQ.add(35658786);
    TQ.add(5278367);
    TQ.add(74381793);

    // print Queue
    System.out.println("Queue1: " + TQ);

    // create object of TransferQueue
    // using LinkedTransferQueue(Collection c)
    // constructor
    TransferQueue<Integer> TQ2
        = new LinkedTransferQueue<Integer>(TQ);

    // print Queue
    System.out.println("Queue2: " + TQ2);
  }
}

//Output:
//Queue1: [7855642, 35658786, 5278367, 74381793]
//Queue2: [7855642, 35658786, 5278367, 74381793]