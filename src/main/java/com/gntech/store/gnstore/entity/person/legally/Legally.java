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

    @Column(name = "cnpj")
    private String cnpj;

    @Column(name = "state_registration")
    private String stateRegistration;

    @Column(name = "municipal_registration")
    private String municipalRegistration;

    @Column(name = "fancy_name")
    private String fancyName;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "category")
    private String category;

}
