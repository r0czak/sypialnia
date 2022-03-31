package com.sypialnia.domain.entities;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TransactionId implements Serializable {
  private static final long serialVersionUID = -4189444674884575754L;

  @Column(name = "transaction_id", nullable = false)
  private Integer transactionId;

  @Column(name = "order_id", nullable = false)
  private Integer orderId;

  @Column(name = "sku_id", nullable = false)
  private Integer skuId;

  public Integer getSkuId() {
    return skuId;
  }

  public void setSkuId(Integer skuId) {
    this.skuId = skuId;
  }

  public Integer getOrderId() {
    return orderId;
  }

  public void setOrderId(Integer orderId) {
    this.orderId = orderId;
  }

  public Integer getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(Integer transactionId) {
    this.transactionId = transactionId;
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderId, transactionId, skuId);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    TransactionId entity = (TransactionId) o;
    return Objects.equals(this.orderId, entity.orderId)
        && Objects.equals(this.transactionId, entity.transactionId)
        && Objects.equals(this.skuId, entity.skuId);
  }
}
