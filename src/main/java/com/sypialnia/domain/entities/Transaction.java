package com.sypialnia.domain.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "transactions", schema = "mydb", catalog = "")
@IdClass(TransactionPK.class)
public class Transaction {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "transaction_id")
  private Integer transactionId;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "order_id")
  private Integer orderId;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "sku_id")
  private Integer skuId;

  @Basic
  @Column(name = "quantity")
  private Integer quantity;

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

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Transaction that = (Transaction) o;
    return transactionId == that.transactionId
        && orderId == that.orderId
        && skuId == that.skuId
        && quantity == that.quantity;
  }

  @Override
  public int hashCode() {
    return Objects.hash(transactionId, orderId, skuId, quantity);
  }
}
