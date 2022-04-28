package com.sypialnia.domain.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "product_skus", schema = "mydb", catalog = "")
@IdClass(ProductSkuPK.class)
public class ProductSku {
  @Basic
  @Column(name = "sku")
  private String sku;

  @Basic
  @Column(name = "price")
  private double price;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "sku_id")
  private Integer skuId;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "product_id")
  private Integer productId;

  public String getSku() {
    return sku;
  }

  public void setSku(String sku) {
    this.sku = sku;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public Integer getSkuId() {
    return skuId;
  }

  public void setSkuId(Integer skuId) {
    this.skuId = skuId;
  }

  public Integer getProductId() {
    return productId;
  }

  public void setProductId(Integer productId) {
    this.productId = productId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ProductSku that = (ProductSku) o;
    return Double.compare(that.price, price) == 0
        && skuId == that.skuId
        && productId == that.productId
        && Objects.equals(sku, that.sku);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sku, price, skuId, productId);
  }
}
