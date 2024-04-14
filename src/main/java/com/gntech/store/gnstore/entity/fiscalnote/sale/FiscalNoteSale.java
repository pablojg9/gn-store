package com.gntech.store.gnstore.entity.fiscalnote.sale;

import com.gntech.store.gnstore.entity.store.sale.buy.StoreSaleBuy;

import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Table(name = "fiscal_note_sale")
@Getter
@Setter
@SequenceGenerator(name = "seq_fiscal_note_sale", sequenceName = "seq_fiscal_note_sale", allocationSize = 1)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class FiscalNoteSale implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_fiscal_note_sale")
  @EqualsAndHashCode.Include
  private Long id;

  @Column(name = "number", nullable = false)
  private String number;

  @Column(name = "series", nullable = false)
  private String series;

  @Column(name = "type", nullable = false)
  private String type;

  @Column(name = "xml", columnDefinition = "TEXT", nullable = false)
  private String xml;

  @Column(name = "pdf", columnDefinition = "TEXT", nullable = false)
  private String pdf;

  @OneToOne
  @JoinColumn(name = "store_sale_buy_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "store_sale_buy_fk"))
  private StoreSaleBuy storeSaleBuy;
}
