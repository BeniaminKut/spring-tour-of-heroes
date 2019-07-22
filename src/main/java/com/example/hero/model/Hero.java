package com.example.hero.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Hero {
    @Id
    @GeneratedValue
    private int id;
    private String name;

}
