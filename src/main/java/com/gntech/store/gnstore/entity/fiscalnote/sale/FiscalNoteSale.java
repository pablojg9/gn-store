package com.gntech.store.gnstore.entity.fiscalnote.sale;

import com.gntech.store.gnstore.entity.sale.buy.store.SaleBuyStore;
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

  @Column(name = "number")
  private String number;

  @Column(name = "series")
  private String series;

  @Column(name = "type")
  private String type;

  @Column(name = "xml", columnDefinition = "TEXT")
  private String xml;

  @Column(name = "pdf", columnDefinition = "TEXT")
  private String pdf;

  @OneToOne
  @JoinColumn(name = "sale_buy_store_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "sale_buy_store_fk"))
  private SaleBuyStore saleBuyStore;
}
