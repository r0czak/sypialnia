package com.sypialnia.domain.entities;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OptionId implements Serializable {
  private static final long serialVersionUID = 1201715283031233119L;

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

  @Override
  public int hashCode() {
    return Objects.hash(productId, optionId);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    OptionId entity = (OptionId) o;
    return Objects.equals(this.productId, entity.productId)
        && Objects.equals(this.optionId, entity.optionId);
  }
}
