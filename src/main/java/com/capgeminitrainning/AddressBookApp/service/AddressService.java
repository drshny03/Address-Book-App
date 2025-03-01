package com.capgeminitrainning.AddressBookApp.service;

import com.capgeminitrainning.AddressBookApp.dto.AddressDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.HashMap;
import java.util.Map;

@Service
@Component
public class AddressService {
    private static final Logger logger = LoggerFactory.getLogger(AddressService.class);
    //map to store address
    Map<Integer, AddressDTO> addressMap;
    private AddressDTO addressDTO;

    //constructor
    @Autowired
    public AddressService(AddressDTO addressDTO){
        this.addressDTO = addressDTO;
        addressMap = new HashMap<>();
    }

    //service for get all address
    public ResponseEntity<Map<Integer, AddressDTO>> getAllAddress() {
        logger.info("retrieving all address.....");
        return ResponseEntity.ok(addressMap);
    }
    //service for get address by id
    public ResponseEntity<AddressDTO> getAddressById(int id){
        logger.info("retrieving address by id.....");
        //check if id present
        if(addressMap.containsKey(id)){
            AddressDTO address = addressMap.get(id);
            return ResponseEntity.ok(address);
        }
        return null;
    }
    //service for update address
    public ResponseEntity<String> putAddress(int id, AddressDTO addressDTO){
        //check if id present
        if(!addressMap.containsKey(id)){
            return ResponseEntity.ok("id not found");
        }
        addressMap.put(id,addressDTO);
        return ResponseEntity.ok("address updated successfully");
    }
    //service to post address
    public ResponseEntity<String> postAddress(AddressDTO address) {
        int id = address.getId();
        addressMap.put(id,address);
        return ResponseEntity.ok("address stored successfully");
    }
    //service for delete address
    public ResponseEntity<String> deleteAddress(int id) {
        //check if id present
        if(!addressMap.containsKey(id)){
            return ResponseEntity.ok("id not found");
        }
        addressMap.remove(id);
        return ResponseEntity.ok("address deleted successfully");
    }

}