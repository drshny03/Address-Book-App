package com.capgeminitrainning.AddressBookApp.controller;

import com.capgeminitrainning.AddressBookApp.dto.AddressDTO;
import com.capgeminitrainning.AddressBookApp.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
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
        log.info("receive rest request for retrieving all addresses");
        return addressService.getAllAddress();
    }
    //method to get address by id
    @GetMapping("/get/{id}")
    public ResponseEntity<AddressDTO> getAddressById(@PathVariable int id){
        log.info("receive rest request for retrieve address with id {}",id);
        return addressService.getAddressById(id);
    }
    //method to post address
    @PostMapping("/post")
    public ResponseEntity<String> postAddress(@RequestBody AddressDTO address){
        log.info("receive rest request to add new address");
        return addressService.postAddress(address);
    }
    //method to put address
    @PutMapping("/put")
    public ResponseEntity<String> putAddress(@RequestParam int id,
                                             @RequestBody AddressDTO address){
        log.info("receive rest request for update address with id {}", id);
        return addressService.putAddress(id,address);
    }
    //method to delete address
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteAddress(@RequestParam int id){
        log.info("receive rest request to delete address with id {}", id);
        return addressService.deleteAddress(id);
    }

}