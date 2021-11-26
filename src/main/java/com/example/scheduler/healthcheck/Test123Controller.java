package com.example.scheduler.healthcheck;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

@RestController
@RequestMapping("/")
@CrossOrigin(originPatterns = "*", allowedHeaders = "*", allowCredentials = "true")
public class Test123Controller {
  Logger log = LoggerFactory.getLogger(Test123Controller.class);

  @PostMapping("/abcd")
  public String set(HttpServletRequest request) {
    log.info("Request Came:");
    Integer data = new Random().nextInt();
    log.info("data: " + data);
    request.getSession().setAttribute("data", data);
    log.info("After set:  " + request.getSession().getAttribute("data"));
    return "Ok";
  }

  @GetMapping("/abcd")
  public Object get(HttpServletRequest request) {
    log.info("Get Request Came:");
    log.info("data: " + request.getSession().getAttribute("data"));
    return "Session is: " + request.getSession().getAttribute("data");
  }
}
