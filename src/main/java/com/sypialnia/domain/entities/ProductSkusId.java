package com.sypialnia.domain.entities;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProductSkusId implements Serializable {
  private static final long serialVersionUID = -2691967507107378139L;
  @Column(name = "sku_id", nullable = false)
  private Integer skuId;
  @Column(name = "product_id", nullable = false)
  private Integer productId;

  public Integer getProductId() {
    return productId;
  }

  public void setProductId(Integer productId) {
    this.productId = productId;
  }

  public Integer getSkuId() {
    return skuId;
  }

  public void setSkuId(Integer skuId) {
    this.skuId = skuId;
  }

  @Override
  public int hashCode() {
    return Objects.hash(productId, skuId);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    ProductSkusId entity = (ProductSkusId) o;
    return Objects.equals(this.productId, entity.productId) &&
        Objects.equals(this.skuId, entity.skuId);
  }
}