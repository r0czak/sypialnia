package com.sypialnia.domain.repositories;

import com.sypialnia.domain.entities.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Integer> {
  // Find by token
  VerificationToken findByToken(String token);
}
