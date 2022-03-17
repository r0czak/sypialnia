package com.sypialnia.domain.entities;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProductId implements Serializable {
  private static final long serialVersionUID = -1461459720083577075L;
  @Column(name = "product_id", nullable = false)
  private Integer productId;
  @Column(name = "category_id", nullable = false)
  private Integer categoryId;
  @Column(name = "vendor_id", nullable = false)
  private Integer vendorId;
  @Column(name = "collection_id", nullable = false)
  private Integer collectionId;

  public Integer getCollectionId() {
    return collectionId;
  }

  public void setCollectionId(Integer collectionId) {
    this.collectionId = collectionId;
  }

  public Integer getVendorId() {
    return vendorId;
  }

  public void setVendorId(Integer vendorId) {
    this.vendorId = vendorId;
  }

  public Integer getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Integer categoryId) {
    this.categoryId = categoryId;
  }

  public Integer getProductId() {
    return productId;
  }

  public void setProductId(Integer productId) {
    this.productId = productId;
  }

  @Override
  public int hashCode() {
    return Objects.hash(productId, vendorId, collectionId, categoryId);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    ProductId entity = (ProductId) o;
    return Objects.equals(this.productId, entity.productId) &&
        Objects.equals(this.vendorId, entity.vendorId) &&
        Objects.equals(this.collectionId, entity.collectionId) &&
        Objects.equals(this.categoryId, entity.categoryId);
  }
}