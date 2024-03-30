package com.gntech.store.gnstore.entity.address;

import com.gntech.store.gnstore.entity.address.enm.AddressType;
import com.gntech.store.gnstore.entity.person.Person;
import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ADDRESS")
@Getter
@Setter
@SequenceGenerator(name = "seq_address", sequenceName = "seq_address", allocationSize = 1)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_address")
    @EqualsAndHashCode.Include
    private Long id;
    private String street;
    private String cep;
    private String number;
    private String complement;
    private String neighborhood;
    private String uf;
    private String city;

    @ManyToOne(targetEntity = Person.class)
    @JoinColumn(name = "person_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "person_fk"))
    private Person person;

    @Column(name = "address_type")
    @Enumerated(EnumType.STRING)
    private AddressType addressType;
}
