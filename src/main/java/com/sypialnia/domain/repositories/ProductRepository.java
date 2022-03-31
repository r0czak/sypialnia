package com.sypialnia.domain.repositories;

public interface ProductRepository
    extends org.springframework.data.jpa.repository.JpaRepository<
        com.sypialnia.domain.entities.Product, com.sypialnia.domain.entities.ProductId> {}
