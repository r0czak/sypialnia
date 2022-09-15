package com.sypialnia.domain.repositories;

import com.sypialnia.domain.entities.Role;
import com.sypialnia.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
  List<User> findAll();

  Optional<User> findByUsername(String username);

  User findByUserId(int userId);

  User findByEmail(String email);

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);

  Role findRoleByUserId(int userId);
}
