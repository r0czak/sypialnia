package com.sypialnia.domain.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "orders", schema = "mydb", catalog = "")
@IdClass(OrderPK.class)
public class Order {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "order_id")
  private int orderId;
  @Basic
  @Column(name = "order_date")
  private Date orderDate;
  @Basic
  @Column(name = "paid")
  private Byte paid;
  @Basic
  @Column(name = "price")
  private Double price;
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "client_id")
  private int clientId;

  public int getOrderId() {
    return orderId;
  }

  public void setOrderId(int orderId) {
    this.orderId = orderId;
  }

  public Date getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(Date orderDate) {
    this.orderDate = orderDate;
  }

  public Byte getPaid() {
    return paid;
  }

  public void setPaid(Byte paid) {
    this.paid = paid;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public int getClientId() {
    return clientId;
  }

  public void setClientId(int clientId) {
    this.clientId = clientId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Order order = (Order) o;
    return orderId == order.orderId && clientId == order.clientId && Objects.equals(orderDate, order.orderDate) && Objects.equals(paid, order.paid) && Objects.equals(price, order.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderId, orderDate, paid, price, clientId);
  }
}
