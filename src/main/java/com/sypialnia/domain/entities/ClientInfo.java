package com.sypialnia.domain.entities;

import javax.persistence.*;

@Entity
@Table(name = "client_info")
public class ClientInfo {
  @EmbeddedId
  private ClientInfoId id;

  @MapsId("addressId")
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "address_id", nullable = false)
  private Address address;

  @MapsId("userId")
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @Column(name = "name", length = 45)
  private String name;

  @Column(name = "surname", length = 45)
  private String surname;

  @Column(name = "phone", length = 9)
  private String phone;

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public ClientInfoId getId() {
    return id;
  }

  public void setId(ClientInfoId id) {
    this.id = id;
  }
}