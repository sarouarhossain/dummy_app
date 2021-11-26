package com.example.scheduler.healthcheck;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Objects;

public record PostRequest (BigInteger serviceGuId,LocalDateTime serviceReportingTime,Integer healthStatus,String errorReason){
  public PostRequest{
    Objects.requireNonNull(serviceGuId);
    Objects.requireNonNull(serviceReportingTime);
    Objects.requireNonNull(healthStatus);
  }
}
