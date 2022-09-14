package com.sypialnia.domain.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "addresses", schema = "mydb")
public class Address {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "address_id")
  private Integer addressId;

  @Basic
  @Column(name = "city")
  private String city;

  @Basic
  @Column(name = "postal_code")
  private String postalCode;

  @Basic
  @Column(name = "street")
  private String street;

  @Basic
  @Column(name = "street_number")
  private String streetNumber;

  @Basic
  @Column(name = "apartment_number")
  private String apartmentNumber;

  public int getAddressId() {
    return addressId;
  }

  public void setAddressId(int addressId) {
    this.addressId = addressId;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getStreetNumber() {
    return streetNumber;
  }

  public void setStreetNumber(String streetNumber) {
    this.streetNumber = streetNumber;
  }

  public String getApartmentNumber() {
    return apartmentNumber;
  }

  public void setApartmentNumber(String apartmentNumber) {
    this.apartmentNumber = apartmentNumber;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Address address = (Address) o;
    return addressId == address.addressId
        && Objects.equals(city, address.city)
        && Objects.equals(postalCode, address.postalCode)
        && Objects.equals(street, address.street)
        && Objects.equals(streetNumber, address.streetNumber)
        && Objects.equals(apartmentNumber, address.apartmentNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(addressId, city, postalCode, street, streetNumber, apartmentNumber);
  }
}
