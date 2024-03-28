package com.polling.ipl.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "persons")
public class Person {

    @Id
    private long id;

    private String name;


}
