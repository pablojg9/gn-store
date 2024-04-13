package com.gntech.store.gnstore.entity.tracking.status;

import com.gntech.store.gnstore.entity.sale.buy.store.SaleBuyStore;
import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "TRACKING_STATUS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "seq_tracking_status", sequenceName = "seq_tracking_status", allocationSize = 1)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TrackingStatus implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tracking_status")
  @EqualsAndHashCode.Include
  @Column(name = "id")
  private Long id;

  @Column(name = "distribution_center")
  private String distributionCenter;

  @Column(name = "city")
  private String city;

  @Column(name = "state")
  private String state;

  @Column(name = "status")
  private String status;

  @ManyToOne
  @JoinColumn(name = "sale_buy_store_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "sale_buy_store_fk"))
  private SaleBuyStore saleBuyStore;
}
