package com.nosso.banco.repository;

import org.springframework.data.repository.CrudRepository;

import com.nosso.banco.model.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {

}
