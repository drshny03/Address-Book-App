package com.capgeminitrainning.AddressBookApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
public @Data class AddressEntity
{
    //Attributes
    @Id
    private int id;
    private String name;
    private String email;
    private long number;
}