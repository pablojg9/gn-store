package com.gntech.store.gnstore.entity.store.sale.buy;

import com.gntech.store.gnstore.entity.address.Address;
import com.gntech.store.gnstore.entity.coupon.discount.CouponDiscount;
import com.gntech.store.gnstore.entity.fiscalnote.sale.FiscalNoteSale;
import com.gntech.store.gnstore.entity.payment.method.PaymentMethod;
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
import jakarta.persistence.OneToOne;
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
@Table(name = "store_sale_buy")
@Getter
@Setter
@SequenceGenerator(name = "seq_store_sale_buy", sequenceName = "seq_store_sale_buy", allocationSize = 1)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class StoreSaleBuy {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_store_sale_buy")
  @EqualsAndHashCode.Include
  @Column(name = "id")
  private Long id;

  @Column(name = "amount")
  private BigDecimal amount;

  @Column(name = "discount_value")
  private BigDecimal discountValue;

  @Column(name = "shipping_value")
  private BigDecimal shippingValue;

  @Column(name = "delivery_day")
  private Integer deliveryDay;

  @Column(name = "sale_date")
  @Temporal(TemporalType.DATE)
  private Date saleDate;

  @Column(name = "delivery_date")
  @Temporal(TemporalType.DATE)
  private Date deliveryDate;


  @ManyToOne(targetEntity = Person.class)
  @JoinColumn(name = "person_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "person_fk"))
  private Person person;

  @ManyToOne
  @JoinColumn(name = "delivery_address_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "delivery_address_fk"))
  private Address deliveryAddress;

  @ManyToOne
  @JoinColumn(name = "billing address_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "billing_address_fk"))
  private Address billingAddress;

  @ManyToOne
  @JoinColumn(name = "payment_method_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "payment_method_fk"))
  private PaymentMethod paymentMethod;

  @OneToOne
  @JoinColumn(name = "fiscal_note_sale_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "fiscal_note_sale_fk"))
  private FiscalNoteSale fiscalNoteSale;

  @ManyToOne
  @JoinColumn(name = "coupon_discount_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "coupon_discount_fk"))
  private CouponDiscount couponDiscount;
}
