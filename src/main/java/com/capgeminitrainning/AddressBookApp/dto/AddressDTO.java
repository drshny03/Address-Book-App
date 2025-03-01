package com.capgeminitrainning.AddressBookApp.dto;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
    //Attributes
    private int id;
    private String name;
    private String email;
    private long number;
}