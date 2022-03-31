package com.sypialnia.domain.entities;

import javax.persistence.*;

@Entity
@Table(name = "transactions")
public class Transaction {
  @EmbeddedId private TransactionId id;

  @MapsId("orderId")
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "order_id", nullable = false, referencedColumnName = "order_id")
  private Order order;

  @MapsId("skuId")
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "sku_id", nullable = false, referencedColumnName = "sku_id")
  private ProductSkus sku;

  @Column(name = "quantity", nullable = false)
  private Integer quantity;

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public ProductSkus getSku() {
    return sku;
  }

  public void setSku(ProductSkus sku) {
    this.sku = sku;
  }

  public Order getOrder() {
    return order;
  }

  public void setOrder(Order order) {
    this.order = order;
  }

  public TransactionId getId() {
    return id;
  }

  public void setId(TransactionId id) {
    this.id = id;
  }
}
