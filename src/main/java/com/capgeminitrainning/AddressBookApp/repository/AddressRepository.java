package com.capgeminitrainning.AddressBookApp.repository;


import com.capgeminitrainning.AddressBookApp.model.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressEntity, Integer>{
}