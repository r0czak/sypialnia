package com.sypialnia.domain.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ProductPK implements Serializable {
  @Column(name = "product_id")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer productId;

  @Column(name = "category_id")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer categoryId;

  @Column(name = "vendor_id")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer vendorId;

  @Column(name = "collection_id")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer collectionId;

  public Integer getProductId() {
    return productId;
  }

  public void setProductId(Integer productId) {
    this.productId = productId;
  }

  public Integer getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Integer categoryId) {
    this.categoryId = categoryId;
  }

  public Integer getVendorId() {
    return vendorId;
  }

  public void setVendorId(Integer vendorId) {
    this.vendorId = vendorId;
  }

  public Integer getCollectionId() {
    return collectionId;
  }

  public void setCollectionId(Integer collectionId) {
    this.collectionId = collectionId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ProductPK productPK = (ProductPK) o;
    return productId == productPK.productId
        && categoryId == productPK.categoryId
        && vendorId == productPK.vendorId
        && collectionId == productPK.collectionId;
  }

  @Override
  public int hashCode() {
    return Objects.hash(productId, categoryId, vendorId, collectionId);
  }
}
