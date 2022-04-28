package com.sypialnia.domain.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "categories", schema = "mydb", catalog = "")
public class Categorie {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "category_id")
  private int categoryId;
  @Basic
  @Column(name = "category_name")
  private String categoryName;
  @Basic
  @Column(name = "description")
  private String description;

  public int getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(int categoryId) {
    this.categoryId = categoryId;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
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
    Categorie categorie = (Categorie) o;
    return categoryId == categorie.categoryId && Objects.equals(categoryName, categorie.categoryName) && Objects.equals(description, categorie.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(categoryId, categoryName, description);
  }
}
