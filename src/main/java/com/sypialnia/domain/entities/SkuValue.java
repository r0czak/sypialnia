package com.sypialnia.domain.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sku_values", schema = "mydb", catalog = "")
@IdClass(SkuValuePK.class)
public class SkuValue {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "sku_id")
  private int skuId;
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "value_id")
  private int valueId;
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "option_id")
  private int optionId;
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "product_id")
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
    SkuValue skuValue = (SkuValue) o;
    return skuId == skuValue.skuId && valueId == skuValue.valueId && optionId == skuValue.optionId && productId == skuValue.productId;
  }

  @Override
  public int hashCode() {
    return Objects.hash(skuId, valueId, optionId, productId);
  }
}
