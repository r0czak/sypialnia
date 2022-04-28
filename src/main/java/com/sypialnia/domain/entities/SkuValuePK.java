package com.sypialnia.domain.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class SkuValuePK implements Serializable {
  @Column(name = "sku_id")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int skuId;
  @Column(name = "value_id")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int valueId;
  @Column(name = "option_id")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int optionId;
  @Column(name = "product_id")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int productId;

  public int getSkuId() {
    return skuId;
  }

  public void setSkuId(int skuId) {
    this.skuId = skuId;
  }

  public int getValueId() {
    return valueId;
  }

  public void setValueId(int valueId) {
    this.valueId = valueId;
  }

  public int getOptionId() {
    return optionId;
  }

  public void setOptionId(int optionId) {
    this.optionId = optionId;
  }

  public int getProductId() {
    return productId;
  }

  public void setProductId(int productId) {
    this.productId = productId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    SkuValuePK that = (SkuValuePK) o;
    return skuId == that.skuId && valueId == that.valueId && optionId == that.optionId && productId == that.productId;
  }

  @Override
  public int hashCode() {
    return Objects.hash(skuId, valueId, optionId, productId);
  }
}