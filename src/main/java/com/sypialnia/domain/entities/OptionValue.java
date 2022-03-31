package com.sypialnia.domain.entities;

import javax.persistence.*;

@Entity
@Table(name = "option_values")
public class OptionValue {
  @EmbeddedId private OptionValueId id;

  @MapsId
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumns({
    @JoinColumn(name = "option_id", referencedColumnName = "option_id", nullable = false),
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false)
  })
  private Option options;

  @Column(name = "value_name", length = 45)
  private String valueName;

  public String getValueName() {
    return valueName;
  }

  public void setValueName(String valueName) {
    this.valueName = valueName;
  }

  public Option getOptions() {
    return options;
  }

  public void setOptions(Option options) {
    this.options = options;
  }

  public OptionValueId getId() {
    return id;
  }

  public void setId(OptionValueId id) {
    this.id = id;
  }
}
