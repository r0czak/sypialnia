package com.sypialnia.domain.entities;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "password_token", schema = "mydb")
@NoArgsConstructor
@IdClass(PasswordResetTokenPK.class)
public class PasswordResetToken {
  // Expires after 10 minutes
  private static final int EXPIRATION = 10;

  @Column(name = "token_id")
  @Id
  private Integer tokenId;

  @Basic
  @Column(name = "token")
  private String token;

  @Basic
  @Column(name = "expiry_date")
  private Date expiryDate;

  @Column(name = "user_id")
  @Id
  private Integer userId;

  public Integer getTokenId() {
    return tokenId;
  }

  public void setTokenId(Integer tokenId) {
    this.tokenId = tokenId;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public Date getExpiryDate() {
    return expiryDate;
  }

  public void setExpiryDate(Date expiryDate) {
    this.expiryDate = expiryDate;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    userId = userId;
  }

  public PasswordResetToken(String token, User user) {
    this.token = token;
    this.userId = user.getUserId();
    this.expiryDate = calculateExpiryDate(EXPIRATION);
  }

  public PasswordResetToken(String token) {
    super();
    this.token = token;
    this.expiryDate = calculateExpiryDate(EXPIRATION);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    PasswordResetToken that = (PasswordResetToken) o;
    return Objects.equals(tokenId, that.tokenId)
        && Objects.equals(token, that.token)
        && Objects.equals(expiryDate, that.expiryDate)
        && Objects.equals(userId, that.userId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tokenId, token, expiryDate, userId);
  }

  private Date calculateExpiryDate(int expiryTimeInMinutes) {
    Calendar cal = Calendar.getInstance();
    cal.setTimeInMillis(new Date().getTime());
    cal.add(Calendar.MINUTE, expiryTimeInMinutes);
    return new Date(cal.getTime().getTime());
  }

  public void updateToken() {
    this.token = UUID.randomUUID().toString();
    this.expiryDate = calculateExpiryDate(EXPIRATION);
  }
}
