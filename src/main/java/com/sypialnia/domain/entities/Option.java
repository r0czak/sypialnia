package com.sypialnia.domain.entities;

import javax.persistence.*;

@Entity
@Table(name = "options")
public class Option {
  @EmbeddedId
  private OptionId id;

  @MapsId("productId")
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "product_id", nullable = false, referencedColumnName = "product_id")
  private Product product;

  @Column(name = "option_name", length = 45)
  private String optionName;

  public String getOptionName() {
    return optionName;
  }

  public void setOptionName(String optionName) {
    this.optionName = optionName;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public OptionId getId() {
    return id;
  }

  public void setId(OptionId id) {
    this.id = id;
  }
}