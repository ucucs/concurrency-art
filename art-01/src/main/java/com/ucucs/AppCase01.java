package com.ucucs;

import com.ucucs.task.RunableTask;

public class AppCase01 {

  /**
   * 用例1: 非后台线程，会等待所有线程执行完,JVM才退出.
   *
   * <p>正常创建的线程为用户线程 线程执行顺序不可控
   */
  public static void main(String[] args) {
    Thread cookThread = new Thread(new RunableTask("cooking"));
    Thread teaThread = new Thread(new RunableTask("teaing"));
    cookThread.start();
    teaThread.start();
    System.out.println("Application end");
  }
}
