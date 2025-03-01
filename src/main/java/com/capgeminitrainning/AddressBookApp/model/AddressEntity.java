package com.capgeminitrainning.AddressBookApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Table(name = "AddressBook")
public @Data class AddressEntity {
    //Attributes
    @Id
    private int id;
    @NotBlank(message = "name should not be blank")
    @Pattern(regexp = "^[A-Z][a-zA-Z]{2,}( [A-Z][a-zA-Z]{2,})?$")
    private String name;
    @NotBlank(message = "not should not be blank")
    @Email(message = "Invalid email format")
    private String email;
    @NotBlank(message = "number should not be blank")
    private long number;
}}