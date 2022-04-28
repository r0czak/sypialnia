package com.sypialnia.domain.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ClientInfoPK implements Serializable {
  @Column(name = "client_id")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer clientId;

  @Column(name = "address_id")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer addressId;

  @Column(name = "user_id")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer userId;

  public Integer getClientId() {
    return clientId;
  }

  public void setClientId(Integer clientId) {
    this.clientId = clientId;
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
    ClientInfoPK that = (ClientInfoPK) o;
    return clientId == that.clientId && addressId == that.addressId && userId == that.userId;
  }

  @Override
  public int hashCode() {
    return Objects.hash(clientId, addressId, userId);
  }
}
