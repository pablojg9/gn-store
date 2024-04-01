package com.gntech.store.gnstore.entity.product.noteitem;

import com.gntech.store.gnstore.entity.fiscalnote.purchase.FiscalNotePurchase;
import com.gntech.store.gnstore.entity.product.Product;
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

@Entity
@Table(name = "NOTE_ITEM_PRODUCT")
@Getter
@Setter
@SequenceGenerator(name = "seq_note_item_product", sequenceName = "seq_note_item_product", allocationSize = 1)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class NoteItem {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_note_item_product")
  @Column(name = "id")
  @EqualsAndHashCode.Include
  private Long id;

  @Column(name = "quantity", nullable = false)
  private Double quantity;

  @ManyToOne(targetEntity = FiscalNotePurchase.class)
  @JoinColumn(name = "fiscal_note_purchase_id", nullable = false, foreignKey = @ForeignKey(name = "fiscal_note_purchase_fk", value = ConstraintMode.CONSTRAINT))
  private FiscalNotePurchase fiscalNotePurchase;

  @ManyToOne(targetEntity = Product.class)
  @JoinColumn(name = "product_id", nullable = false, foreignKey = @ForeignKey(name = "product_fk", value = ConstraintMode.CONSTRAINT))
  private Product product;

}
