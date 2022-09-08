package ru.vdv.Threads;

public class MainThreads {

  public static void main(String[] args) throws InterruptedException {

    Thread thread3 = new Thread(new T3());

    thread3.start();
    thread3.join();

    System.out.println("Fin");
  }
}

class T1 implements Runnable {

  @Override
  public void run() {
    System.out.println(Thread.currentThread()
                             .getName() + " отработал поток T1");
  }
}

class T2 implements Runnable {

  @Override
  public void run() {
    Thread thread1 = new Thread(new T1());
    try {
      thread1.start();
      thread1.join();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    System.out.println(Thread.currentThread()
                             .getName() + " отработал поток T2");
  }
}

class T3 implements Runnable {

  @Override
  public void run() {
    Thread thread2 = new Thread(new T2());
    try {
      thread2.start();
      thread2.join();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    System.out.println(Thread.currentThread()
                             .getName() + " отработал поток T3");
  }
}
