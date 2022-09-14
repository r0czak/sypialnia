package com.sypialnia.domain.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "products", schema = "mydb", catalog = "")
@IdClass(ProductPK.class)
public class Product {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "product_id")
  private Integer productId;

  @Basic
  @Column(name = "title")
  private String title;

  @Basic
  @Column(name = "description")
  private String description;

  @Basic
  @Column(name = "visibility")
  private Byte visibility;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "category_id")
  private Integer categoryId;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "vendor_id")
  private Integer vendorId;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "collection_id")
  private Integer collectionId;

  public Integer getProductId() {
    return productId;
  }

  public void setProductId(Integer productId) {
    this.productId = productId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Byte getVisibility() {
    return visibility;
  }

  public void setVisibility(Byte visibility) {
    this.visibility = visibility;
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
    Product product = (Product) o;
    return productId == product.productId
        && categoryId == product.categoryId
        && vendorId == product.vendorId
        && collectionId == product.collectionId
        && Objects.equals(title, product.title)
        && Objects.equals(description, product.description)
        && Objects.equals(visibility, product.visibility);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        productId, title, description, visibility, categoryId, vendorId, collectionId);
  }
}
