package com.gntech.store.gnstore.entity.coupon.discount;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "coupon_discount")
@Getter
@Setter
@SequenceGenerator(name = "seq_coupon_discount", sequenceName = "seq_coupon_discount", allocationSize = 1)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CouponDiscount implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_coupon_discount")
  @Column(name = "id")
  @EqualsAndHashCode.Include
  private Long id;

  @Column(name = "coupon_code")
  private String couponCode;

  @Column(name = "value_discount")
  private BigDecimal valueDiscount;

  @Column(name = "value_discount_percentage")
  private BigDecimal valueDiscountPercentage;

  @Column(name = "date_expired_coupon")
  @Temporal(TemporalType.DATE)
  private Date dateExpiredCoupon;
}
