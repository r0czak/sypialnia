package com.sypialnia.domain.repositories;

import com.sypialnia.domain.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
  Optional<Role> findByRoleName(String name);

  Role findByRoleId(int roleId);
}
