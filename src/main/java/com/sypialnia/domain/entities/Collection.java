package com.sypialnia.domain.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Collection {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "collection_id")
  private int collectionId;
  @Basic
  @Column(name = "collection_name")
  private String collectionName;
  @Basic
  @Column(name = "description")
  private String description;

  public int getCollectionId() {
    return collectionId;
  }

  public void setCollectionId(int collectionId) {
    this.collectionId = collectionId;
  }

  public String getCollectionName() {
    return collectionName;
  }

  public void setCollectionName(String collectionName) {
    this.collectionName = collectionName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Collection that = (Collection) o;
    return collectionId == that.collectionId && Objects.equals(collectionName, that.collectionName) && Objects.equals(description, that.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(collectionId, collectionName, description);
  }
}
