package com.sypialnia.domain.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "categories", schema = "mydb")
public class Category {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "category_id")
  private Integer categoryId;

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
    Category category = (Category) o;
    return categoryId == category.categoryId
        && Objects.equals(categoryName, category.categoryName)
        && Objects.equals(description, category.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(categoryId, categoryName, description);
  }
}
