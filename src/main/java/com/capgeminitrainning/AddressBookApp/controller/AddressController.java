package com.capgeminitrainning.AddressBookApp.controller;

import com.capgeminitrainning.AddressBookApp.dto.AddressDTO;
import com.capgeminitrainning.AddressBookApp.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Map;


@RestController
@RequestMapping("/address")
public class AddressController {
    private AddressService addressService;

    //constructor
    @Autowired
    public AddressController(AddressService addressService){
        this.addressService = addressService;
    }

    //method to get all address
    @GetMapping("/")
    public ResponseEntity<Map<Integer, AddressDTO>> getAllAddress(){
        return addressService.getAllAddress();
    }
    //method to get address by id
    @GetMapping("/get/{id}")
    public ResponseEntity<AddressDTO> getAddressById(@PathVariable int id){
        return addressService.getAddressById(id);
    }
    //method to post address
    @PostMapping("/post")
    public ResponseEntity<String> postAddress(@RequestBody AddressDTO address){
        return addressService.postAddress(address);
    }
    //method to put address
    @PutMapping("/put")
    public ResponseEntity<String> putAddress(@RequestParam int id,
                                             @RequestBody AddressDTO address){
        return addressService.putAddress(id,address);
    }
    //method to delete address
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteAddress(@RequestParam int id){
        return addressService.deleteAddress(id);
    }

}