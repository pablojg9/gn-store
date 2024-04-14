package com.gntech.store.gnstore.entity.person.legally;

import com.gntech.store.gnstore.entity.person.Person;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "PERSON_LEGALLY")
@PrimaryKeyJoinColumn(name = "id")
@Getter
@Setter
public class Legally extends Person {

  @Column(name = "cnpj", nullable = false)
  private String cnpj;

  @Column(name = "state_registration", nullable = false)
  private String stateRegistration;

  @Column(name = "municipal_registration")
  private String municipalRegistration;

  @Column(name = "fancy_name", nullable = false)
  private String fancyName;

  @Column(name = "company_name", nullable = false)
  private String companyName;

  @Column(name = "category")
  private String category;
}
