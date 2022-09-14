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
  private Integer skuId;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "value_id")
  private Integer valueId;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "option_id")
  private Integer optionId;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "product_id")
  private Integer productId;

  public Integer getSkuId() {
    return skuId;
  }

  public void setSkuId(Integer skuId) {
    this.skuId = skuId;
  }

  public Integer getValueId() {
    return valueId;
  }

  public void setValueId(Integer valueId) {
    this.valueId = valueId;
  }

  public Integer getOptionId() {
    return optionId;
  }

  public void setOptionId(Integer optionId) {
    this.optionId = optionId;
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
    SkuValue skuValue = (SkuValue) o;
    return skuId == skuValue.skuId
        && valueId == skuValue.valueId
        && optionId == skuValue.optionId
        && productId == skuValue.productId;
  }

  @Override
  public int hashCode() {
    return Objects.hash(skuId, valueId, optionId, productId);
  }
}
