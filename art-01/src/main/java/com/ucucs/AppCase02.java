package com.ucucs;

import com.ucucs.task.DelayRunableTask;

public class AppCase02 {

  /** 用例2: 后台线程，用户线程执行完,JVM就退出，哪怕后台线程还没执行完. */
  public static void main(String[] args) {
    Thread cookThread = new Thread(new DelayRunableTask("cooking"));
    cookThread.setDaemon(true);
    cookThread.start();
    System.out.println("Application end");
  }
}
