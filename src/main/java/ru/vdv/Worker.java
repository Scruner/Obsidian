package ru.vdv;

// Java code to illustrate Reentrant Locks

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

class Worker implements Runnable {

  String name;
  ReentrantLock re;

  public Worker(ReentrantLock rl, String n) {
    re = rl;
    name = n;
  }

  public void run() {
    boolean done = false;
    while (!done) {
      //Getting Outer Lock
      boolean ans = re.tryLock();

      // Returns True if lock is free
      if (ans) {
        try {
          Date d = new Date();
          SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
          System.out.println("task name - " + name
              + " outer lock acquired at "
              + ft.format(d)
              + " Doing outer work");
          Thread.sleep(1500);

          // Getting Inner Lock
          re.lock();
          try {
            d = new Date();
            ft = new SimpleDateFormat("hh:mm:ss");
            System.out.println("task name - " + name
                + " inner lock acquired at "
                + ft.format(d)
                + " Doing inner work");
            System.out.println("Lock Hold Count - " + re.getHoldCount());
            Thread.sleep(1500);
          } catch (InterruptedException e) {
            e.printStackTrace();
          } finally {
            //Inner lock release
            System.out.println("task name - " + name +
                " releasing inner lock");

            re.unlock();
          }
          System.out.println("Lock Hold Count - " + re.getHoldCount());
          System.out.println("task name - " + name + " work done");

          done = true;
        } catch (InterruptedException e) {
          e.printStackTrace();
        } finally {
          //Outer lock release
          System.out.println("task name - " + name +
              " releasing outer lock");

          re.unlock();
          System.out.println("Lock Hold Count - " +
              re.getHoldCount());
        }
      } else {
        System.out.println("task name - " + name +
            " waiting for lock");
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
}

class test {

  static final int MAX_T = 2;

  public static void main(String[] args) {
    ReentrantLock rel = new ReentrantLock();
    ExecutorService pool = Executors.newFixedThreadPool(MAX_T);
    Runnable w1 = new Worker(rel, "Job1");
    Runnable w2 = new Worker(rel, "Job2");
    Runnable w3 = new Worker(rel, "Job3");
    Runnable w4 = new Worker(rel, "Job4");
    pool.execute(w1);
    pool.execute(w2);
    pool.execute(w3);
    pool.execute(w4);
    pool.shutdown();
  }
}

//Output:
//task name - Job2 waiting for lock
//task name - Job1 outer lock acquired at 07:46:00 Doing outer work
//task name - Job2 waiting for lock
//task name - Job1 inner lock acquired at 07:46:01 Doing inner work
//Lock Hold Count - 2
//task name - Job2 waiting for lock
//task name - Job2 waiting for lock
//task name - Job1 releasing inner lock
//Lock Hold Count - 1
//task name - Job1 work done
//task name - Job1 releasing outer lock
//Lock Hold Count - 0
//task name - Job3 outer lock acquired at 07:46:03 Doing outer work
//task name - Job2 waiting for lock
//task name - Job3 inner lock acquired at 07:46:04 Doing inner work
//Lock Hold Count - 2
//task name - Job2 waiting for lock
//task name - Job2 waiting for lock
//task name - Job3 releasing inner lock
//Lock Hold Count - 1
//task name - Job3 work done
//task name - Job3 releasing outer lock
//Lock Hold Count - 0
//task name - Job4 outer lock acquired at 07:46:06 Doing outer work
//task name - Job2 waiting for lock
//task name - Job4 inner lock acquired at 07:46:07 Doing inner work
//Lock Hold Count - 2
//task name - Job2 waiting for lock
//task name - Job2 waiting for lock
//task name - Job4 releasing inner lock
//Lock Hold Count - 1
//task name - Job4 work done
//task name - Job4 releasing outer lock
//Lock Hold Count - 0
//task name - Job2 outer lock acquired at 07:46:10 Doing outer work
//task name - Job2 inner lock acquired at 07:46:11 Doing inner work
//Lock Hold Count - 2
//task name - Job2 releasing inner lock
//Lock Hold Count - 1
//task name - Job2 work done
//task name - Job2 releasing outer lock
//Lock Hold Count - 0
