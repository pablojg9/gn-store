package com.gntech.store.gnstore.entity.store.sale.item;

import com.gntech.store.gnstore.entity.person.Person;
import com.gntech.store.gnstore.entity.product.Product;
import com.gntech.store.gnstore.entity.store.sale.buy.StoreSaleBuy;
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
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "store_sale_item")
@Getter
@Setter
@SequenceGenerator(name = "seq_store_sale_item", sequenceName = "seq_store_sale_item", allocationSize = 1)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class StoreSaleItem implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_store_sale_item")
  @EqualsAndHashCode.Include
  @Column(name = "id")
  private Long id;

  private Double quantity;

  @ManyToOne
  @JoinColumn(name = "product_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "product_fk"))
  private Product product;

  @ManyToOne
  @JoinColumn(name = "store_sale_buy_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "store_sale_buy_fk"))
  private StoreSaleBuy storeSaleBuy;

}
