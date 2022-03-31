package com.sypialnia.domain.entities;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SkuValueId implements Serializable {
  private static final long serialVersionUID = 3746808428170144127L;

  @Column(name = "sku_id", nullable = false)
  private Integer skuId;

  @Column(name = "value_id", nullable = false)
  private Integer valueId;

  @Column(name = "option_id", nullable = false)
  private Integer optionId;

  @Column(name = "product_id", nullable = false)
  private Integer productId;

  public Integer getProductId() {
    return productId;
  }

  public void setProductId(Integer productId) {
    this.productId = productId;
  }

  public Integer getOptionId() {
    return optionId;
  }

  public void setOptionId(Integer optionId) {
    this.optionId = optionId;
  }

  public Integer getValueId() {
    return valueId;
  }

  public void setValueId(Integer valueId) {
    this.valueId = valueId;
  }

  public Integer getSkuId() {
    return skuId;
  }

  public void setSkuId(Integer skuId) {
    this.skuId = skuId;
  }

  @Override
  public int hashCode() {
    return Objects.hash(valueId, productId, optionId, skuId);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    SkuValueId entity = (SkuValueId) o;
    return Objects.equals(this.valueId, entity.valueId)
        && Objects.equals(this.productId, entity.productId)
        && Objects.equals(this.optionId, entity.optionId)
        && Objects.equals(this.skuId, entity.skuId);
  }
}
