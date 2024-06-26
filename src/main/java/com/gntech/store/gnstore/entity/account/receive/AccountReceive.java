package com.gntech.store.gnstore.entity.account.receive;


import com.gntech.store.gnstore.entity.account.receive.enm.AccountReceiveStatus;
import com.gntech.store.gnstore.entity.person.Person;

import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "account_receive")
@Getter
@Setter
@SequenceGenerator(name = "seq_account_receive", sequenceName = "seq_account_receive", allocationSize = 1)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AccountReceive {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_account_receive")
  @Column(name = "id")
  @EqualsAndHashCode.Include
  private Long id;

  @Column(name = "description", nullable = false)
  private String description;

  @Column(name = "status", nullable = false)
  @Enumerated(EnumType.STRING)
  private AccountReceiveStatus status;

  @Column(name = "expired_date", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date expiredDate;

  @Column(name = "payed_date")
  @Temporal(TemporalType.DATE)
  private Date payedDate;

  @Column(name = "total_value", nullable = false)
  private BigDecimal totalValue;

  @Column(name = "discount_value")
  private BigDecimal discountValue;

  @ManyToOne(targetEntity = Person.class)
  @JoinColumn(name = "person_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "person_fk"))
  private Person person;
}
