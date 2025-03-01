package com.capgeminitrainning.AddressBookApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "AddressBook")
public @Data class AddressEntity {
    //Attributes
    @Id
    private int id;
    private String name;
    private String email;
    private long number;
}