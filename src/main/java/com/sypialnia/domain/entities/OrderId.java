package com.sypialnia.domain.entities;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderId implements Serializable {
  private static final long serialVersionUID = -2147283497178218547L;

  @Column(name = "order_id", nullable = false)
  private Integer orderId;

  @Column(name = "client_id", nullable = false)
  private Integer clientId;

  public Integer getClientId() {
    return clientId;
  }

  public void setClientId(Integer clientId) {
    this.clientId = clientId;
  }

  public Integer getOrderId() {
    return orderId;
  }

  public void setOrderId(Integer orderId) {
    this.orderId = orderId;
  }

  @Override
  public int hashCode() {
    return Objects.hash(clientId, orderId);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    OrderId entity = (OrderId) o;
    return Objects.equals(this.clientId, entity.clientId)
        && Objects.equals(this.orderId, entity.orderId);
  }
}
