package com.sypialnia.domain.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "options", schema = "mydb", catalog = "")
@IdClass(OptionPK.class)
public class Option {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "option_id")
  private int optionId;
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "product_id")
  private int productId;
  @Basic
  @Column(name = "option_name")
  private String optionName;

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

  public String getOptionName() {
    return optionName;
  }

  public void setOptionName(String optionName) {
    this.optionName = optionName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Option option = (Option) o;
    return optionId == option.optionId && productId == option.productId && Objects.equals(optionName, option.optionName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(optionId, productId, optionName);
  }
}
