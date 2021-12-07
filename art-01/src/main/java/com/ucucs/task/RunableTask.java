package com.ucucs.task;

public class RunableTask implements Runnable {

  private final String name;

  public RunableTask(String name) {
    this.name = name;
  }

  @Override
  public void run() {
    System.out.println("Task is running:" + name);
  }
}
