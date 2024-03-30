package com.gntech.store.gnstore.entity.account.pay.enm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public enum AccountPayStatus {

  PAY("Pay"),
  EXPIRED("Expired"),
  OPEN("Open"),
  PAID("Paid"),
  RENT("Rent"),
  EMPLOYEE("Employee"),
  RENEGOTIATED("Renegotiated");

  private final String description;
}
