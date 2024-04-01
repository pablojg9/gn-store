package com.gntech.store.gnstore.entity.product.image;

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

import java.io.Serializable;

@Entity
@Table(name = "IMAGE_PRODUCT")
@Getter
@Setter
@SequenceGenerator(name = "seq_image_product", sequenceName = "seq_image_product", allocationSize = 1)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Image implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_image_product")
  @Column(name = "id")
  @EqualsAndHashCode.Include
  private Long id;

  @Column(name = "image_original", columnDefinition = "TEXT")
  private String imageOriginal;

  @Column(name = "image_thumbnail", columnDefinition = "TEXT")
  private String imageThumbnail;

  @ManyToOne(targetEntity = Product.class)
  @JoinColumn(name = "product_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "product_fk"))
  private Product product;
}
