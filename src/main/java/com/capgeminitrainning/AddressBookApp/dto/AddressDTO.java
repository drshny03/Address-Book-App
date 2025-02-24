package com.capgeminitrainning.AddressBookApp.dto;

public class AddressDTO {
    //attribute
    //Attributes
    private int id;
    private String name;
    private String email;
    private long number;

    //constructor
    public AddressDTO() {}
    public AddressDTO(int id, String name, String email, long number) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.number = number;
    }
    //getter and setter
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getNumber() {
        return number;
    }
    public void setNumber(long number) {
        this.number = number;
    }
}
