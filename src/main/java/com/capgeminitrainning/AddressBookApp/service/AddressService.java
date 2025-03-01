package com.capgeminitrainning.AddressBookApp.service;

import com.capgeminitrainning.AddressBookApp.dto.AddressDTO;
import com.capgeminitrainning.AddressBookApp.exception.AddressNotFoundException;
import com.capgeminitrainning.AddressBookApp.model.AddressEntity;
import com.capgeminitrainning.AddressBookApp.repository.AddressRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Slf4j
@Service
@Component
public class AddressService {
    AddressRepository addressRepository;
    ModelMapper modelMapper;
    //constructor
    @Autowired
    public AddressService(AddressRepository addressRepository, ModelMapper modelMapper){
        this.addressRepository = addressRepository;
        this.modelMapper = modelMapper;
    }

    //service for get all address
    public List<AddressDTO> getAllAddress() {
        log.info("retrieving all address.....");
        List<AddressEntity> addressEntityList = addressRepository.findAll();
        return addressEntityList.stream()
                .map(entity -> modelMapper.map(entity, AddressDTO.class))
                .toList();
    }
    //service for get address by id
    public AddressDTO getAddressById(int id){
        log.info("retrieving address for id {}" , id);
        //check if id present
        AddressEntity addressEntity = addressRepository.findById(id).orElseThrow(() ->
                new AddressNotFoundException("Address with id "+ id + " not found"));

        return modelMapper.map(addressEntity, AddressDTO.class);
    }
    //service for update address
    public AddressDTO putAddress(int id, AddressDTO addressDTO){
        log.info("updating address for id {}" , id);
        //check if id present
        AddressEntity addressEntity = addressRepository.findById(id)
                .orElseThrow(() -> new AddressNotFoundException("Address with ID " + id + " not found"));

        //update fields
        addressEntity.setNumber(addressDTO.getNumber());
        addressEntity.setEmail(addressDTO.getEmail());
        //save updated entity
        AddressEntity updatedAddress = addressRepository.save(addressEntity);
        return modelMapper.map(updatedAddress, AddressDTO.class);
    }
    //service to post address
    public AddressDTO postAddress(AddressDTO address) {
        log.info("Adding new address to address book");
        AddressEntity addressEntity = modelMapper.map(address, AddressEntity.class);
        AddressEntity savedAddress = addressRepository.save(addressEntity);

        return modelMapper.map(savedAddress, AddressDTO.class);
    }
    //service for delete address
    public String deleteAddress(int id) {
        log.info("deleting address for id {}" , id);
        //check if id present
        AddressEntity addressEntity = addressRepository.findById(id)
                .orElseThrow(() -> new AddressNotFoundException("Address with id " + id + " not found"));

        //delete address
        addressRepository.delete(addressEntity);
        return "Address deleted successfully";
    }
}