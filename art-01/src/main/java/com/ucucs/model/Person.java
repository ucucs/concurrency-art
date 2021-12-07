package com.ucucs.model;

import lombok.SneakyThrows;

public class Person {

  @SneakyThrows
  public synchronized void methodA() {
    System.out.println("method A is running:" + Thread.currentThread().getName());
    Thread.sleep(2000L);
    System.out.println("method A is running finish:" + Thread.currentThread().getName());
  }

  public synchronized void methodB() {
    System.out.println("method B is running");
  }
}
