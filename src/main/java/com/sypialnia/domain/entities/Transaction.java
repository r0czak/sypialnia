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
  private int transactionId;
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "order_id")
  private int orderId;
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "sku_id")
  private int skuId;
  @Basic
  @Column(name = "quantity")
  private Object quantity;

  public int getTransactionId() {
    return transactionId;
  }

  public void setTransactionId(int transactionId) {
    this.transactionId = transactionId;
  }

  public int getOrderId() {
    return orderId;
  }

  public void setOrderId(int orderId) {
    this.orderId = orderId;
  }

  public int getSkuId() {
    return skuId;
  }

  public void setSkuId(int skuId) {
    this.skuId = skuId;
  }

  public Object getQuantity() {
    return quantity;
  }

  public void setQuantity(Object quantity) {
    this.quantity = quantity;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Transaction that = (Transaction) o;
    return transactionId == that.transactionId && orderId == that.orderId && skuId == that.skuId && Objects.equals(quantity, that.quantity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(transactionId, orderId, skuId, quantity);
  }
}
