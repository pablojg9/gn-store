package com.gntech.store.gnstore.entity.product;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
@Getter
@Setter
@SequenceGenerator(name = "seq_product", sequenceName = "seq_product", allocationSize = 1)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Product implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_product")
  @Column(name = "id")
  @EqualsAndHashCode.Include
  private Long id;

  @Column(name = "unit_type")
  private String unitType;

  @Column(name = "name")
  private String name;

  @Column(name = "description", columnDefinition = "TEXT", length = 2000)
  private String description;

  @Column(name = "active")
  private Boolean active = Boolean.TRUE;

  // todo - item nota produto criar

  @Column(name = "weight")
  private Double weight;

  @Column(name = "width")
  private Double width;

  @Column(name = "height")
  private Double height;

  @Column(name = "depth")
  private Double depth;

  @Column(name = "sale_value")
  private BigDecimal saleValue;

  @Column(name = "quantity_stock")
  private Integer quantityStock;

  @Column(name = "quantity_alert_stock")
  private Integer quantityAlertStock;

  @Column(name = "quantity_alert_stock_verification")
  private Boolean quantityAlertStockVerification = Boolean.FALSE;

  @Column(name = "link_youtube")
  private String linkYoutube;

  @Column(name = "quantity_click")
  private Integer quantityClick;
}
