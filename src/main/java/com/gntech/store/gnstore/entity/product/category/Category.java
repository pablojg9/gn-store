package com.gntech.store.gnstore.entity.product.category;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "CATEGORY_PRODUCT")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "seq_category_product", sequenceName = "seq_category_product", allocationSize = 1)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_category_product")
    @EqualsAndHashCode.Include
    @Column(name = "id")
    private Long id;

    @Column(name = "description", nullable = false)
    private String description;
}
