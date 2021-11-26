package com.example.scheduler;

import java.util.Date;

public class RunnableTask implements Runnable {
  private String message;

  public RunnableTask(String message) {
    this.message = message;
  }

  /**
   * When an object implementing interface {@code Runnable} is used to create a thread, starting the
   * thread causes the object's {@code run} method to be called in that separately executing thread.
   *
   * <p>The general contract of the method {@code run} is that it may take any action whatsoever.
   *
   * @see Thread#run()
   */
  @Override
  public void run() {
    System.out.println(
        new Date()
            + " .. Hello from :"
            + message
            + " , thread name: "
            + Thread.currentThread().getName());
  }
}
