package com.sypialnia.domain.entities;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "role_id", nullable = false)
  private Integer roleId;

  @Column(name = "role_name", nullable = false, length = 45)
  private String roleName;

  public Integer getId() {
    return roleId;
  }

  public void setId(Integer id) {
    this.roleId = id;
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }
}
