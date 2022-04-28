package com.sypialnia.domain.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "option_values", schema = "mydb", catalog = "")
@IdClass(OptionValuePK.class)
public class OptionValue {
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
  @Basic
  @Column(name = "value_name")
  private String valueName;

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

  public String getValueName() {
    return valueName;
  }

  public void setValueName(String valueName) {
    this.valueName = valueName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    OptionValue that = (OptionValue) o;
    return valueId == that.valueId && optionId == that.optionId && productId == that.productId && Objects.equals(valueName, that.valueName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(valueId, optionId, productId, valueName);
  }
}
