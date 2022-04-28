package com.sypialnia.domain.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class OptionValuePK implements Serializable {
  @Column(name = "value_id")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer valueId;

  @Column(name = "option_id")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer optionId;

  @Column(name = "product_id")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer productId;

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
    OptionValuePK that = (OptionValuePK) o;
    return valueId == that.valueId && optionId == that.optionId && productId == that.productId;
  }

  @Override
  public int hashCode() {
    return Objects.hash(valueId, optionId, productId);
  }
}
