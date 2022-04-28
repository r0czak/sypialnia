package com.sypialnia.domain.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class OrderPK implements Serializable {
  @Column(name = "order_id")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer orderId;

  @Column(name = "client_id")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer clientId;

  public Integer getOrderId() {
    return orderId;
  }

  public void setOrderId(Integer orderId) {
    this.orderId = orderId;
  }

  public Integer getClientId() {
    return clientId;
  }

  public void setClientId(Integer clientId) {
    this.clientId = clientId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    OrderPK orderPK = (OrderPK) o;
    return orderId == orderPK.orderId && clientId == orderPK.clientId;
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderId, clientId);
  }
}
