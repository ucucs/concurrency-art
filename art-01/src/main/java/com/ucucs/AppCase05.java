package com.ucucs;

import com.ucucs.model.Person;
import com.ucucs.task.PersonRunableTask;
import lombok.SneakyThrows;

public class AppCase05 {

  /** 用例5: 线程调用对象方法，同步阻塞 */
  @SneakyThrows
  public static void main(String[] args) {
    Person person = new Person();

    // 同步调用同一个方法，会等待第一个执行完
    // Thread.sleep不会释放锁
    Thread cookThread = new Thread(new PersonRunableTask(person, 0), "cookThread-0");
    Thread teaThread = new Thread(new PersonRunableTask(person, 0), "teaThread-1");
    cookThread.start();
    teaThread.start();

    System.out.println("Application end");
  }
}
