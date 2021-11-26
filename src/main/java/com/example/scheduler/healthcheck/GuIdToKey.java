package com.example.scheduler.healthcheck;

import java.math.BigInteger;

public enum GuIdToKey {
  RPP(BigInteger.valueOf(100070), "ee3bbef5592bed79ec82b11d78038df5", "RPP"),
  BTA(BigInteger.valueOf(100071), "e1fa867927c483af731a279fee3284e7", "BTA"),
  CPA(BigInteger.valueOf(100072), "295193214080af8c41ede9c9526a423d", "CPA");

  BigInteger guId;
  String accessKey;
  String serviceName;

  GuIdToKey(BigInteger guId, String accessKey, String serviceName) {
    this.guId = guId;
    this.accessKey = accessKey;
    this.serviceName = serviceName;
  }

  public static boolean isValid(BigInteger guId, String accessKey) {
    for (GuIdToKey var : GuIdToKey.values()) {
      if (var.guId.equals(guId) && var.accessKey.equals(accessKey)) {
        return true;
      }
    }
    return false;
  }
}
