package com.sypialnia.domain.repositories;

import com.sypialnia.domain.entities.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Integer> {
  PasswordResetToken findByToken(String token);
}
