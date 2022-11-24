package com.jpa.exercise.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Publisher {
    @Id
    private Long id;
    public String name;
    public String address;
}
