package com.sypialnia.domain.entities;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OptionValueId implements Serializable {
  private static final long serialVersionUID = 2696560738470543665L;
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

  @Override
  public int hashCode() {
    return Objects.hash(valueId, productId, optionId);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    OptionValueId entity = (OptionValueId) o;
    return Objects.equals(this.valueId, entity.valueId) &&
        Objects.equals(this.productId, entity.productId) &&
        Objects.equals(this.optionId, entity.optionId);
  }
}