package com.example.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;

@RestController
@RequestMapping("/")
public class TestController {
  private final ThreadPoolTaskScheduler taskScheduler;

  public TestController(ThreadPoolTaskScheduler taskScheduler) {
    this.taskScheduler = taskScheduler;
  }

  @GetMapping("")
  public String test() throws InterruptedException {
    System.out.println("Testing");
    var ct = System.currentTimeMillis() + 3000;

    Map<Integer, ScheduledFuture<?>> map = new HashMap<>();

    for (int i = 1; i < 1000; i++) {
      var task = new RunnableTask("task" + i);
      var time = new Date(ct + i * 2);
      var future = taskScheduler.schedule(task, time);
      map.put(i, future);
    }

    for (int i = 500; i < 1000; i++) {
      var future = map.get(i);
      future.cancel(true);
    }

    Thread.sleep(3008);
    var future1 = map.get(1);
    future1.cancel(true);

    return "Hello";
  }
}
