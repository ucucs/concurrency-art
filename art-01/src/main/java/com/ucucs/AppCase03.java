package com.ucucs;

import lombok.SneakyThrows;

public class AppCase03 {

  /**
   * 用例3: 后台线程，用户线程执行完,JVM就退出，哪怕后台线程还没执行完.
   *
   * <p>后台线程变成同步调用，等待运行完才退出
   */
  @SneakyThrows
  public static void main(String[] args) {
    Thread cookThread = new Thread(new DelayRunableTask("cooking"));
    cookThread.setDaemon(true);
    cookThread.start();
    cookThread.join();
    // 这句的作用是，阻塞当前线程2秒，如果5秒线程cookThread还没执行完，则不再等待直接退出
    // cookThread.join(2000L);
    System.out.println("Application end");
  }
}
