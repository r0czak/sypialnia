package com.sypialnia.domain.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
public class Order {
  @EmbeddedId private OrderId id;

  @MapsId("clientId")
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "client_id", nullable = false, referencedColumnName = "client_id")
  private ClientInfo client;

  @Column(name = "order_date", nullable = false)
  private LocalDate orderDate;

  @Column(name = "paid")
  private Integer paid;

  @Column(name = "price")
  private Double price;

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Integer getPaid() {
    return paid;
  }

  public void setPaid(Integer paid) {
    this.paid = paid;
  }

  public LocalDate getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(LocalDate orderDate) {
    this.orderDate = orderDate;
  }

  public ClientInfo getClient() {
    return client;
  }

  public void setClient(ClientInfo client) {
    this.client = client;
  }

  public OrderId getId() {
    return id;
  }

  public void setId(OrderId id) {
    this.id = id;
  }
}
