package com.ucucs.task;

import com.ucucs.model.Person;

public class PersonRunableTask implements Runnable {

  private final Person person;
  private final int taskIndex;

  public PersonRunableTask(Person person, int taskIndex) {
    this.person = person;
    this.taskIndex = taskIndex;
  }

  @Override
  public void run() {
    System.out.println("Task is running:" + Thread.currentThread().getName());
    if (taskIndex == 0) {
      person.methodA();
    } else {
      person.methodB();
    }
  }
}
