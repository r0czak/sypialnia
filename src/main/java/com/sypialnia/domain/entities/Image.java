package com.sypialnia.domain.entities;

import javax.persistence.*;

@Entity
@Table(name = "images")
public class Image {
  @EmbeddedId private ImageId id;

  @MapsId("productId")
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "product_id", nullable = false, referencedColumnName = "product_id")
  private Product product;

  @Column(name = "image_name", length = 45)
  private String imageName;

  public String getImageName() {
    return imageName;
  }

  public void setImageName(String imageName) {
    this.imageName = imageName;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public ImageId getId() {
    return id;
  }

  public void setId(ImageId id) {
    this.id = id;
  }
}
