package com.sypialnia.domain.repositories;

import com.sypialnia.domain.entities.Address;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AddressRepository extends CrudRepository<Address, Integer> {
  List<Address> findById(int id);
}