package com.gntech.store.gnstore.entity.person;

import com.gntech.store.gnstore.entity.address.Address;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@SequenceGenerator(name = "seq_person", sequenceName = "seq_person", allocationSize = 1)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class Person implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_person")
  @EqualsAndHashCode.Include
  @Column(name = "id")
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "email", nullable = false)
  private String email;

  @Column(name = "phone", nullable = false)
  private String phone;

  @OneToMany(mappedBy = "person", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<Address> addressList = new ArrayList<>();
}
