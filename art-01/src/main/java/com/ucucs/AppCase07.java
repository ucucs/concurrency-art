package com.ucucs;

import com.ucucs.task.DelayRunableTask;
import lombok.SneakyThrows;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AppCase07 {

  /** 用例7: 创建线程池，默认拒绝策略 */
  @SneakyThrows
  public static void main(String[] args) {
    // 用最底层的方法
    // int corePoolSize = Runtime.getRuntime().availableProcessors();
    int corePoolSize = 1;
    int maxPoolSize = corePoolSize * 2;
    ThreadPoolExecutor executor =
        new ThreadPoolExecutor(
            corePoolSize, maxPoolSize, 30L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5));

    for (int i = 0; i < 10; i++) {
      // 可能会抛出拒绝异常,默认拒绝策略
      try {
        executor.execute(new DelayRunableTask("task" + i));
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }

    // 如果没有这句，后台会一直运行
    executor.shutdown();
    System.out.println("Application end");
  }
}
