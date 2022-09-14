package com.sypialnia.domain.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "mydb")
public class User {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "user_id")
  private Integer userId;

  @Basic
  @Column(name = "username")
  private String username;

  @Basic
  @Column(name = "password")
  private String password;

  @Basic
  @Column(name = "email")
  private String email;

  @Basic
  @Column(name = "is_admin")
  private Byte isAdmin;

  @Basic
  @Column(name = "enabled")
  private Byte enabled;

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
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

  public Byte getIsAdmin() {
    return isAdmin;
  }

  public void setIsAdmin(Byte isAdmin) {
    this.isAdmin = isAdmin;
  }

  public Byte getEnabled() {
    return enabled;
  }

  public void setEnabled(Byte enabled) {
    this.enabled = enabled;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    User user = (User) o;
    return userId == user.userId
        && Objects.equals(username, user.username)
        && Objects.equals(password, user.password)
        && Objects.equals(isAdmin, user.isAdmin)
        && Objects.equals(email, user.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, username, password, email, isAdmin);
  }
}
