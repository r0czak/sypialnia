package com.sypialnia.domain.entities;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ImageId implements Serializable {
  private static final long serialVersionUID = 6459157388999870218L;

  @Column(name = "image_id", nullable = false)
  private Integer imageId;

  @Column(name = "product_id", nullable = false)
  private Integer productId;

  public Integer getProductId() {
    return productId;
  }

  public void setProductId(Integer productId) {
    this.productId = productId;
  }

  public Integer getImageId() {
    return imageId;
  }

  public void setImageId(Integer imageId) {
    this.imageId = imageId;
  }

  @Override
  public int hashCode() {
    return Objects.hash(imageId, productId);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    ImageId entity = (ImageId) o;
    return Objects.equals(this.imageId, entity.imageId)
        && Objects.equals(this.productId, entity.productId);
  }
}
