package ru.vdv;

// Java program to implement SynchronousQueue API.

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class SynchronousQAPI<E> {

  public SynchronousQueue<E> synchronousQ;

  // we create a SynchronousQueue with no fair policy

  public SynchronousQAPI() {
    synchronousQ = new SynchronousQueue<E>();
  }

  // we create a SynchronousQueue with fair policy

  public SynchronousQAPI(boolean fair) {
    synchronousQ = new SynchronousQueue<E>();
  }

  // As we discussed above in API overview that
  // SynchronousQueue has 2 supported operations put() and
  // take() So, we will implement this methods only

  // put() method: It insert element at tail of the queue
  // and used to wait until the queue is full.

  public void put(E e) throws InterruptedException {
    synchronousQ.put(e);
  }

  // take() method: return element at the head of the
  // queue

  public E take() throws InterruptedException {
    return synchronousQ.take();
  }

  // Implementation of Put Thread (producer)
  class Put implements Runnable {

    @SuppressWarnings("rawtypes")
    BlockingQueue SynchronousQueue;

    @SuppressWarnings("rawtypes")
    public Put(BlockingQueue q) {
      this.SynchronousQueue = q;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void run() {
      try {
        // put the data
        SynchronousQueue.put(1);
        System.out.println(
            "1 added to synchronous queue.");
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  class Take implements Runnable {

    @SuppressWarnings("rawtypes")
    BlockingQueue SynchronousQueue;

    @SuppressWarnings("rawtypes")
    public Take(BlockingQueue q) {
      this.SynchronousQueue = q;
    }

    @Override
    public void run() {
      try {
        // take out the previously inserted data
        this.SynchronousQueue.take();

        System.out.println(
            "1 removed from synchronous queue.");
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public static void main(String[] args)
      throws InterruptedException {
    SynchronousQAPI<Integer> synchronousQueue
        = new SynchronousQAPI<Integer>();

    new Thread(new SynchronousQAPI<>().new Put(
        synchronousQueue.synchronousQ))
        .start();

    new Thread(new SynchronousQAPI<>().new Take(
        synchronousQueue.synchronousQ))
        .start();
  }
}

//Output:
//1 removed from synchronous queue.
//1 added to synchronous queue.
