package com.gntech.store.gnstore.entity.account.receive.enm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public enum AccountReceiveStatus {

  PAY("Pay"),
  EXPIRED("Expired"),
  OPEN("Open"),
  PAID("Paid");

  private final String description;
}
