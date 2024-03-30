package com.gntech.store.gnstore.entity.payment.method;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "payment_method")
@Getter
@Setter
@SequenceGenerator(name = "seq_payment_method", sequenceName = "seq_payment_method", allocationSize = 1)
@AllArgsConstructor
@NoArgsConstructor
public class PaymentMethod implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_payment_method")
  @Column(name = "id")
  private Long id;

  @Column(name = "description")
  private String description;

}
