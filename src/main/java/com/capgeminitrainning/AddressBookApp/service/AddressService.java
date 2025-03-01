package com.capgeminitrainning.AddressBookApp.service;

import com.capgeminitrainning.AddressBookApp.dto.AddressDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@Component
public class AddressService {
    //map to store address
    Map<Integer, AddressDTO> addressMap;

    //constructor
    public AddressService(){
        addressMap = new HashMap<>();
    }

    //service for get all address
    public ResponseEntity<Map<Integer, AddressDTO>> getAllAddress() {
        log.info("retrieving all address.....");
        return ResponseEntity.ok(addressMap);
    }
    //service for get address by id
    public ResponseEntity<AddressDTO> getAddressById(int id){
        log.info("retrieving address for id {}" , id);
        //check if id present
        if(addressMap.containsKey(id)){
            AddressDTO address = addressMap.get(id);
            return ResponseEntity.ok(address);
        }
        return null;
    }
    //service for update address
    public ResponseEntity<String> putAddress(int id, AddressDTO addressDTO){
        log.info("updating address for id {}" , id);
        //check if id present
        if(!addressMap.containsKey(id)){
            return ResponseEntity.ok("id not found");
        }
        addressMap.put(id,addressDTO);
        return ResponseEntity.ok("address updated successfully");
    }
    //service to post address
    public ResponseEntity<String> postAddress(AddressDTO address) {
        log.info("Adding new address to address book");
        int id = address.getId();
        addressMap.put(id,address);
        return ResponseEntity.ok("address stored successfully");
    }
    //service for delete address
    public ResponseEntity<String> deleteAddress(int id) {
        log.info("deleting address for id {}" , id);
        //check if id present
        if(!addressMap.containsKey(id)){
            return ResponseEntity.ok("id not found");
        }
        addressMap.remove(id);
        return ResponseEntity.ok("address deleted successfully");
    }

}