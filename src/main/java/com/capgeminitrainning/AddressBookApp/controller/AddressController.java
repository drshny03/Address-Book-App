package com.capgeminitrainning.AddressBookApp.controller;

import com.capgeminitrainning.AddressBookApp.dto.AddressDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/address")
public class AddressController {
    //map to store address
    Map<Integer, AddressDTO> addressMap;

    //constructor
    public AddressController(){
        addressMap = new HashMap<>();
    }

    //method to get all address
    @GetMapping("/")
    public ResponseEntity<Map<Integer, AddressDTO>> getAllAddress(){
        return ResponseEntity.ok(addressMap);
    }
    //method to get address by id
    @GetMapping("/get/{id}")
    public ResponseEntity<AddressDTO> getAddressById(@PathVariable int id){
        //check if id present
        if(addressMap.containsKey(id)){
            AddressDTO address = addressMap.get(id);
            return ResponseEntity.ok(address);
        }
        return null;
    }
    //method to post address
    @PostMapping("/post")
    public ResponseEntity<String> postAddress(@RequestBody AddressDTO address){
        int id = address.getId();
        addressMap.put(id,address);
        return ResponseEntity.ok("address stored successfully");
    }
    //method to put address
    @PutMapping("/put")
    public ResponseEntity<String> putAddress(@RequestParam int id,
                                             @RequestBody AddressDTO address){
        //check if id present
        if(!addressMap.containsKey(id)){
            return ResponseEntity.ok("id not found");
        }
        addressMap.put(id,address);
        return ResponseEntity.ok("address updated successfully");
    }
    //method to delete address
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteAddress(@RequestParam int id){
        //check if id present
        if(!addressMap.containsKey(id)){
            return ResponseEntity.ok("id not found");
        }
        addressMap.remove(id);
        return ResponseEntity.ok("address deleted successfully");
    }

}
