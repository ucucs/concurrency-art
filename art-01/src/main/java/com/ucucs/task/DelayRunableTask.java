package com.ucucs.task;

import lombok.SneakyThrows;

public class DelayRunableTask implements Runnable {

  private final String name;

  public DelayRunableTask(String name) {
    this.name = name;
  }

  @SneakyThrows
  @Override
  public void run() {
    System.out.println("Task is waiting 2 second:" + name);
    Thread.sleep(2000L);
    System.out.println("Task is running finish:" + name);
  }
}
