package com.gntech.store.gnstore.entity.person.physical;

import com.gntech.store.gnstore.entity.person.Person;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity(name = "PERSON_PHYSICAL")
@PrimaryKeyJoinColumn(name = "id")
@Getter
@Setter
public class Physical extends Person implements Serializable {

  @Column(name = "cpf", nullable = false)
  private String cpf;

  @Temporal(TemporalType.DATE)
  @Column(name = "date_birth", nullable = false)
  private Date dateBirth;
}
