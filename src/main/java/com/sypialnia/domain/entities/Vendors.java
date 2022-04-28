package com.sypialnia.domain.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Vendors {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "vendor_id")
  private int vendorId;
  @Basic
  @Column(name = "vendor_name")
  private String vendorName;
  @Basic
  @Column(name = "description")
  private String description;

  public int getVendorId() {
    return vendorId;
  }

  public void setVendorId(int vendorId) {
    this.vendorId = vendorId;
  }

  public String getVendorName() {
    return vendorName;
  }

  public void setVendorName(String vendorName) {
    this.vendorName = vendorName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Vendors vendors = (Vendors) o;
    return vendorId == vendors.vendorId && Objects.equals(vendorName, vendors.vendorName) && Objects.equals(description, vendors.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(vendorId, vendorName, description);
  }
}
