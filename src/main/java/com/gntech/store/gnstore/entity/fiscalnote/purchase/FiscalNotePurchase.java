package com.gntech.store.gnstore.entity.fiscalnote.purchase;

import com.gntech.store.gnstore.entity.account.pay.AccountPay;
import com.gntech.store.gnstore.entity.person.Person;
import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
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

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "FISCAL_NOTE_PURCHASE")
@Getter
@Setter
@SequenceGenerator(name = "seq_fiscal_note_purchase", sequenceName = "seq_fiscal_note_purchase", allocationSize = 1)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class FiscalNotePurchase  implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_fiscal_note_purchase")
  @Column(name = "id")
  @EqualsAndHashCode.Include
  private Long id;

  @Column(name = "number_note")
  private String numberNote;

  @Column(name = "note_series")
  private String noteSeries;

  @Column(name = "description_observation")
  private String descriptionObservation;

  @Column(name = "value_total")
  private BigDecimal valueTotal;

  @Column(name = "value_discount")
  private BigDecimal valueDiscount;

  @Column(name = "icms")
  private BigDecimal icms;

  @Column(name = "purchase_date")
  @Temporal(TemporalType.DATE)
  private Date purchaseDate;

  @ManyToOne(targetEntity = Person.class)
  @JoinColumn(name = "person_id", nullable = false, foreignKey = @ForeignKey(name = "person_fk", value = ConstraintMode.CONSTRAINT))
  private Person person;

  @ManyToOne(targetEntity = AccountPay.class)
  @JoinColumn(name = "account_pay_id", nullable = false, foreignKey = @ForeignKey(name = "account_pay_fk", value = ConstraintMode.CONSTRAINT))
  private AccountPay accountPay;

}
