package com.sypialnia.domain.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ImagePK implements Serializable {
  @Column(name = "image_id")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer imageId;

  @Column(name = "product_id")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer productId;

  public Integer getImageId() {
    return imageId;
  }

  public void setImageId(Integer imageId) {
    this.imageId = imageId;
  }

  public Integer getProductId() {
    return productId;
  }

  public void setProductId(Integer productId) {
    this.productId = productId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ImagePK imagePK = (ImagePK) o;
    return imageId == imagePK.imageId && productId == imagePK.productId;
  }

  @Override
  public int hashCode() {
    return Objects.hash(imageId, productId);
  }
}
