package com.sypialnia.domain.repositories;

import com.sypialnia.domain.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}