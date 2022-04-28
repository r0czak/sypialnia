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
  private int productId;
  @Column(name = "category_id")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int categoryId;
  @Column(name = "vendor_id")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int vendorId;
  @Column(name = "collection_id")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int collectionId;

  public int getProductId() {
    return productId;
  }

  public void setProductId(int productId) {
    this.productId = productId;
  }

  public int getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(int categoryId) {
    this.categoryId = categoryId;
  }

  public int getVendorId() {
    return vendorId;
  }

  public void setVendorId(int vendorId) {
    this.vendorId = vendorId;
  }

  public int getCollectionId() {
    return collectionId;
  }

  public void setCollectionId(int collectionId) {
    this.collectionId = collectionId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ProductPK productPK = (ProductPK) o;
    return productId == productPK.productId && categoryId == productPK.categoryId && vendorId == productPK.vendorId && collectionId == productPK.collectionId;
  }

  @Override
  public int hashCode() {
    return Objects.hash(productId, categoryId, vendorId, collectionId);
  }
}
