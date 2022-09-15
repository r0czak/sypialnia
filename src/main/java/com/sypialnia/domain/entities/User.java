package com.sypialnia.domain.entities;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users")
@NoArgsConstructor
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id", nullable = false)
  private Integer userId;

  @Column(name = "username", length = 45)
  private String username;

  @Column(name = "password")
  private String password;

  @Column(name = "email", nullable = false, length = 45)
  private String email;

  @Column(name = "enabled", nullable = false)
  private Byte enabled;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "roles_role_id", nullable = false)
  private Role rolesRole;

  public User(String username, String email, String encode) {
    this.username = username;
    this.email = email;
    this.password = encode;
    this.enabled = 1;
  }

  public Integer getId() {
    return userId;
  }

  public void setId(Integer userId) {
    this.userId = userId;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Byte getEnabled() {
    return enabled;
  }

  public void setEnabled(Byte enabled) {
    this.enabled = enabled;
  }

  public Role getRolesRole() {
    return rolesRole;
  }

  public void setRolesRole(Role rolesRole) {
    this.rolesRole = rolesRole;
  }
}
