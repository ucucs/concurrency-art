package com.ucucs;

import com.ucucs.model.Person;
import com.ucucs.task.PersonRunableTask;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class AppCase06 {

  /** 用例6: 线程调用对象方法，同步阻塞 */
  @SneakyThrows
  public static void main(String[] args) {
    Person person = new Person();

    // 同步调用同一个方法，会等待第一个执行完
    // Thread.sleep不会释放锁
    List<Thread> threadList = new ArrayList<>(10);
    for (int i = 0; i < 10; i++) {
      Thread cookThread = new Thread(new PersonRunableTask(person, i % 2), "cookThread-" + i);
      threadList.add(cookThread);
    }

    threadList.forEach(Thread::start);
    System.out.println("Application end");
  }
}
