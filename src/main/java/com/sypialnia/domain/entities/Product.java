package com.sypialnia.domain.entities;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
  @EmbeddedId private ProductId id;

  @MapsId("categoryId")
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "category_id", nullable = false)
  private Category category;

  @MapsId("vendorId")
  @OneToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "vendor_id", nullable = false)
  private Vendor vendor;

  @MapsId("collectionId")
  @OneToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "collection_id", nullable = false)
  private Collection collection;

  @Column(name = "title", nullable = false, length = 100)
  private String title;

  @Column(name = "description", length = 500)
  private String description;

  @Column(name = "visibility")
  private Integer visibility;

  public Integer getVisibility() {
    return visibility;
  }

  public void setVisibility(Integer visibility) {
    this.visibility = visibility;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Collection getCollection() {
    return collection;
  }

  public void setCollection(Collection collection) {
    this.collection = collection;
  }

  public Vendor getVendor() {
    return vendor;
  }

  public void setVendor(Vendor vendor) {
    this.vendor = vendor;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public ProductId getId() {
    return id;
  }

  public void setId(ProductId id) {
    this.id = id;
  }
}
