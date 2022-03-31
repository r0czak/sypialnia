package com.sypialnia.domain.entities;

import javax.persistence.*;

@Entity
@Table(name = "sku_values")
public class SkuValue {
  @EmbeddedId private SkuValueId id;

  @MapsId
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumns({
    @JoinColumn(name = "value_id", referencedColumnName = "value_id", nullable = false),
    @JoinColumn(name = "option_id", referencedColumnName = "option_id", nullable = false),
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false)
  })
  private OptionValue optionValues;

  public OptionValue getOptionValues() {
    return optionValues;
  }

  public void setOptionValues(OptionValue optionValues) {
    this.optionValues = optionValues;
  }

  public SkuValueId getId() {
    return id;
  }

  public void setId(SkuValueId id) {
    this.id = id;
  }

  // TODO Reverse Engineering! Migrate other columns to the entity
}
