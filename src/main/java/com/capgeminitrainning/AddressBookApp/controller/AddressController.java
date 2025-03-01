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

import java.util.List;
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
    public ResponseEntity<List<AddressDTO>> getAllAddress(){
        log.info("receive rest request for retrieving all addresses");
        //get all address
        List<AddressDTO> addressDTOList = addressService.getAllAddress();
        return ResponseEntity.ok(addressDTOList);
    }
    //method to get address by id
    @GetMapping("/get/{id}")
    public ResponseEntity<AddressDTO> getAddressById(@PathVariable int id){
        log.info("receive rest request for retrieve address with id {}",id);
        //find address by id
        AddressDTO addressDTO = addressService.getAddressById(id);
        return ResponseEntity.ok(addressDTO);
    }
    //method to post address
    @PostMapping("/post")
    public ResponseEntity<AddressDTO> postAddress(@Valid @RequestBody AddressDTO address){
        log.info("receive rest request to add new address");
        //service call to post new address
        AddressDTO addressDTO = addressService.postAddress(address);
        return ResponseEntity.ok(addressDTO);
    }
    //method to put address
    @PutMapping("/put/{id}")
    public ResponseEntity<AddressDTO> putAddress(@PathVariable int id,
                                                 @Valid @RequestBody AddressDTO address){
        log.info("receive rest request for update address with id {}", id);
        //service call to update address
        AddressDTO addressDTO = addressService.putAddress(id,address);
        return ResponseEntity.ok(addressDTO);
    }
    //method to delete address
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable int id){
        log.info("receive rest request to delete address with id {}", id);
        return ResponseEntity.ok(addressService.deleteAddress(id));
    }

}