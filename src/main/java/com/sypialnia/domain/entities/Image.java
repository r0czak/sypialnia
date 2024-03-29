package com.sypialnia.domain.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "images", schema = "mydb")
@IdClass(ImagePK.class)
public class Image {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "image_id")
  private Integer imageId;

  @Basic
  @Column(name = "image_name")
  private String imageName;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "product_id")
  private Integer productId;

  public Integer getImageId() {
    return imageId;
  }

  public void setImageId(Integer imageId) {
    this.imageId = imageId;
  }

  public String getImageName() {
    return imageName;
  }

  public void setImageName(String imageName) {
    this.imageName = imageName;
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
    Image image = (Image) o;
    return imageId == image.imageId
        && productId == image.productId
        && Objects.equals(imageName, image.imageName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(imageId, imageName, productId);
  }
}
