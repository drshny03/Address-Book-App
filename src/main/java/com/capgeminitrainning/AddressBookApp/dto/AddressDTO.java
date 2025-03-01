package com.capgeminitrainning.AddressBookApp.dto;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
    @NotBlank(message = "name should not be blank")
    @Pattern(regexp = "^[A-Z][a-zA-Z]{2,}( [A-Z][a-zA-Z]{2,})?$")
    private String name;
    @NotBlank(message = "not should not be blank")
    @Email(message = "Invalid email format")
    private String email;
    @NotNull(message = "number should not be null")
    private long number;
}