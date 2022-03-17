package com.sypialnia.domain.entities;

import javax.persistence.*;

@Entity
@Table(name = "vendors")
public class Vendor {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "vendor_id", nullable = false)
  private Integer id;

  @Column(name = "vendor_name", length = 45)
  private String vendorName;

  @Column(name = "description", length = 2000)
  private String description;

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getVendorName() {
    return vendorName;
  }

  public void setVendorName(String vendorName) {
    this.vendorName = vendorName;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}
