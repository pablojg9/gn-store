package com.gntech.store.gnstore.entity.address.enm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public enum AddressType {

  CHARGE("CHARGE"),
  DELIVERY("DELIVERY");

  private final String description;
}
