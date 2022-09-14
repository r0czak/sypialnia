package com.sypialnia.domain.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class PasswordResetTokenPK implements Serializable {
  @Column(name = "token_id")
  @Id
  private Integer tokenId;

  @Column(name = "user_id")
  @Id
  private Integer userId;

  public Integer getTokenId() {
    return tokenId;
  }

  public void setTokenId(Integer tokenId) {
    this.tokenId = tokenId;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    PasswordResetTokenPK that = (PasswordResetTokenPK) o;
    return Objects.equals(tokenId, that.tokenId) && Objects.equals(userId, that.userId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tokenId, userId);
  }
}
