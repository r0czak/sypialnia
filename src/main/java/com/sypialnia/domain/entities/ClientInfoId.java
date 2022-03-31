package com.sypialnia.domain.entities;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ClientInfoId implements Serializable {
  private static final long serialVersionUID = -2886170795871655924L;

  @Column(name = "client_id", nullable = false)
  private Integer clientId;

  @Column(name = "address_id", nullable = false)
  private Integer addressId;

  @Column(name = "user_id", nullable = false)
  private Integer userId;

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public Integer getAddressId() {
    return addressId;
  }

  public void setAddressId(Integer addressId) {
    this.addressId = addressId;
  }

  public Integer getClientId() {
    return clientId;
  }

  public void setClientId(Integer clientId) {
    this.clientId = clientId;
  }

  @Override
  public int hashCode() {
    return Objects.hash(clientId, userId, addressId);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    ClientInfoId entity = (ClientInfoId) o;
    return Objects.equals(this.clientId, entity.clientId)
        && Objects.equals(this.userId, entity.userId)
        && Objects.equals(this.addressId, entity.addressId);
  }
}
