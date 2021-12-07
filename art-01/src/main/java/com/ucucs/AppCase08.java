package com.ucucs;

import com.ucucs.task.RunableTask;
import lombok.SneakyThrows;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AppCase08 {

  /** 用例8: 创建线程池，任何的拒绝策略都不会有影响 */
  @SneakyThrows
  public static void main(String[] args) {
    // 用最底层的方法
    // int corePoolSize = Runtime.getRuntime().availableProcessors();
    int corePoolSize = 1;
    int maxPoolSize = corePoolSize * 2;
    ThreadPoolExecutor executor =
        new ThreadPoolExecutor(
            corePoolSize,
            maxPoolSize,
            30L,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(),
            new ThreadPoolExecutor.DiscardOldestPolicy());

    // 虽然默认是拒绝策略，但是LinkedBlockingQueue没有给容量参数时，可以理解为Int.max无限长

    for (int i = 0; i < 10; i++) {
      // 所以此处不会抛出异常
      executor.execute(new RunableTask("task" + i));
    }

    // 如果没有这句，后台会一直运行
    executor.shutdown();
    System.out.println("Application end");
  }
}
