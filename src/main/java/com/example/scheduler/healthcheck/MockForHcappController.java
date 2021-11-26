package com.example.scheduler.healthcheck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.Random;

@RestController
@RequestMapping("/health")
public class MockForHcappController {
  private Random random;

  MockForHcappController() {
    random = new Random();
  }

  @PostMapping("/autoevent")
  public PostResponse post(
      @RequestHeader("AccessKey") String accessKey, @RequestBody PostRequest postRequest) {

    if (!GuIdToKey.isValid(postRequest.serviceGuId(), accessKey)) {
      throw new ArithmeticException("Invalid request");
    }

    Long eventIdLong = random.nextLong();
    var eventId = new BigInteger(String.valueOf(eventIdLong));
    var message =
        "Accepted: "
            + postRequest.serviceGuId()
            + " , health status: "
            + postRequest.healthStatus();

    return new PostResponse(eventId, message);
  }

  public BigInteger get() {
    return new BigInteger("1");
  }
}
