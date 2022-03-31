package com.sypialnia.domain.entities;

import javax.persistence.*;

@Entity
@Table(name = "collection")
public class Collection {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "collection_id", nullable = false)
  private Integer id;

  @Column(name = "collection_name", length = 45)
  private String collectionName;

  @Column(name = "description", length = 2000)
  private String description;

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getCollectionName() {
    return collectionName;
  }

  public void setCollectionName(String collectionName) {
    this.collectionName = collectionName;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}
