package com.wad.project.proj.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue
    private Long id;
    private String city;

    public Address(String city) {
        this.city = city;
    }
}
