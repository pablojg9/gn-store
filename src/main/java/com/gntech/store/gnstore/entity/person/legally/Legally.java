package com.gntech.store.gnstore.entity.person.legally;

import com.gntech.store.gnstore.entity.person.Person;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "PERSON_LEGALLY")
@PrimaryKeyJoinColumn(name = "id")
@Getter
@Setter
public class Legally extends Person {

    private String cnpj;
    private String stateRegistration;
    private String municipalRegistration;
    private String fancyName;
    private String companyName;
    private String category;

}
