package com.sypialnia.domain.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "client_info", schema = "mydb")
@IdClass(ClientInfoPK.class)
public class ClientInfo {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "client_id")
  private Integer clientId;

  @Basic
  @Column(name = "name")
  private String name;

  @Basic
  @Column(name = "surname")
  private String surname;

  @Basic
  @Column(name = "phone")
  private String phone;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "address_id")
  private Integer addressId;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "user_id")
  private Integer userId;

  public Integer getClientId() {
    return clientId;
  }

  public void setClientId(Integer clientId) {
    this.clientId = clientId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Integer getAddressId() {
    return addressId;
  }

  public void setAddressId(Integer addressId) {
    this.addressId = addressId;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ClientInfo that = (ClientInfo) o;
    return clientId == that.clientId
        && addressId == that.addressId
        && userId == that.userId
        && Objects.equals(name, that.name)
        && Objects.equals(surname, that.surname)
        && Objects.equals(phone, that.phone);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clientId, name, surname, phone, addressId, userId);
  }
}
