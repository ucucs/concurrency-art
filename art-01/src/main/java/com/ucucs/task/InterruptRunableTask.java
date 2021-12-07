package com.ucucs.task;

public class InterruptRunableTask implements Runnable {

  private final String name;

  public InterruptRunableTask(String name) {
    this.name = name;
  }

  @Override
  public void run() {
    System.out.println("Task is waiting 2 second:" + name);
    while (!Thread.currentThread().isInterrupted()) {
      try {
        System.out.println("Task is before sleep:" + name);
        Thread.sleep(2000L);
        System.out.println("Task is after sleep:" + name);
      } catch (InterruptedException e) {
        e.printStackTrace();
        break;
      }
    }
    System.out.println("Task is running finish:" + name);
  }
}
