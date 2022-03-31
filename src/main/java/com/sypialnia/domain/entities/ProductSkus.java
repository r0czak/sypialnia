package com.sypialnia.domain.entities;

import javax.persistence.*;

@Entity
@Table(name = "product_skus")
public class ProductSkus {
  @EmbeddedId private ProductSkusId id;

  @MapsId("skuId")
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "sku_id", nullable = false, referencedColumnName = "sku_id")
  private SkuValue sku;

  @MapsId("productId")
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "product_id", nullable = false, referencedColumnName = "product_id")
  private Product product;

  @Column(name = "sku", nullable = false, length = 45)
  private String sku1;

  @Column(name = "price", nullable = false)
  private Double price;

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public String getSku1() {
    return sku1;
  }

  public void setSku1(String sku1) {
    this.sku1 = sku1;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public SkuValue getSku() {
    return sku;
  }

  public void setSku(SkuValue sku) {
    this.sku = sku;
  }

  public ProductSkusId getId() {
    return id;
  }

  public void setId(ProductSkusId id) {
    this.id = id;
  }
}
