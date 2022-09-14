package com.sypialnia.domain.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class TransactionPK implements Serializable {
  @Column(name = "transaction_id")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer transactionId;

  @Column(name = "order_id")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer orderId;

  @Column(name = "sku_id")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer skuId;

  public Integer getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(Integer transactionId) {
    this.transactionId = transactionId;
  }

  public Integer getOrderId() {
    return orderId;
  }

  public void setOrderId(Integer orderId) {
    this.orderId = orderId;
  }

  public Integer getSkuId() {
    return skuId;
  }

  public void setSkuId(Integer skuId) {
    this.skuId = skuId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    TransactionPK that = (TransactionPK) o;
    return transactionId == that.transactionId && orderId == that.orderId && skuId == that.skuId;
  }

  @Override
  public int hashCode() {
    return Objects.hash(transactionId, orderId, skuId);
  }
}
