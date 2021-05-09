package com.wad.project.proj.domain;


import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode(exclude = {"cards","faculties"})
@ToString(exclude = {"cards","faculties"})
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Card> cards = new HashSet<>();

    @ManyToMany(mappedBy = "students", cascade = CascadeType.PERSIST)
    private Set<Faculty> faculties = new HashSet<>();

    public void addCard(Card c){
        cards.add(c);
        c.setStudent(this);
    }

    public Student(String name) {
        this.name = name;
    }
}
