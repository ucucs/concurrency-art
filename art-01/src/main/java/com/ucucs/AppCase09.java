package com.ucucs;

import com.ucucs.task.DelayRunableTask;
import lombok.SneakyThrows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AppCase09 {

  /** 用例9: 创建线程池 */
  @SneakyThrows
  public static void main(String[] args) {
    // Executors底层是使用link，无限长,所以拒绝策略不生效
    ExecutorService executor = Executors.newSingleThreadExecutor();
    for (int i = 0; i < 10; i++) {
      // 所以此处不会抛出异常
      executor.execute(new DelayRunableTask("task" + i));
    }

    // 如果没有这句，后台会一直运行
    executor.shutdown();
    System.out.println("Application end");
  }
}
