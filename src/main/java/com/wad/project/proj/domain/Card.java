package com.wad.project.proj.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString(exclude = "student")
@NoArgsConstructor
public class Card {

    @Id
    @GeneratedValue
    private Long id;

    private String IBAN;

    @ManyToOne
    private Student student;

    public Card(String IBAN) {
        this.IBAN = IBAN;
    }
}
