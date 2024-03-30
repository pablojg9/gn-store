package com.gntech.store.gnstore.entity.account.pay;

import com.gntech.store.gnstore.entity.account.pay.enm.AccountPayStatus;
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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "account_pay")
@Getter
@Setter
@SequenceGenerator(name = "seq_account_pay", sequenceName = "seq_account_pay", allocationSize = 1)
@AllArgsConstructor
@NoArgsConstructor
public class AccountPay {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_account_pay")
  @Column(name = "id")
  private Long id;

  @Column(name = "description")
  private String description;

  @Column(name = "status")
  @Enumerated(EnumType.STRING)
  private AccountPayStatus status;

  @Column(name = "expired_date")
  @Temporal(TemporalType.DATE)
  private Date expiredDate;

  @Column(name = "payed_date")
  @Temporal(TemporalType.DATE)
  private Date payedDate;

  @Column(name = "total_value")
  private BigDecimal totalValue;

  @Column(name = "discount_value")
  private BigDecimal discountValue;

  @ManyToOne(targetEntity = Person.class)
  @JoinColumn(name = "person_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "person_fk"))
  private Person person;

  @ManyToOne(targetEntity = Person.class)
  @JoinColumn(name = "person_supplier_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "person_supplier_id"))
  private Person person_supplier;

}
