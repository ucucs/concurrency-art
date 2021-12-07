package com.ucucs;

import com.ucucs.task.InterruptRunableTask;
import lombok.SneakyThrows;

public class AppCase04 {

  /**
   * 用例4: 线程组，中断线程组所有
   *
   * <p>线程组中断，会触发中断异常(特定情况，例如sleep)
   */
  @SneakyThrows
  public static void main(String[] args) {
    ThreadGroup threadGroup = new ThreadGroup("caseGroup");
    Thread cookThread = new Thread(threadGroup, new InterruptRunableTask("cooking"), "cookThread");
    Thread teaThread = new Thread(threadGroup, new InterruptRunableTask("teaing"), "teaThread");
    cookThread.start();
    teaThread.start();

    Thread.sleep(5000L);

    threadGroup.interrupt();

    // Join方法很容易引起代码不执行下面的，因为会挂起线程等待
    cookThread.join();
    teaThread.join();
    System.out.println("Application end");
  }
}
