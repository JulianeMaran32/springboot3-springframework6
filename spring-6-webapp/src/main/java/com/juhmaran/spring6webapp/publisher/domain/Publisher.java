package com.juhmaran.spring6webapp.publisher.domain;

import com.juhmaran.spring6webapp.book.domain.Book;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Juliane Maran
 *
 * @since 29/05/2025
 */
@Entity
public class Publisher {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String publisherName;
  private String address;
  private String city;
  private String state;
  private String zipCode;

  @OneToMany(mappedBy = "publisher")
  private Set<Book> books = new HashSet<>();

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getPublisherName() {
    return publisherName;
  }

  public void setPublisherName(String publisherName) {
    this.publisherName = publisherName;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  public Set<Book> getBooks() {
    return books;
  }

  public void setBooks(Set<Book> books) {
    this.books = books;
  }

  @Override
  public String toString() {
    return "Publisher{" +
      "id=" + id +
      ", publisherName='" + publisherName + '\'' +
      ", address='" + address + '\'' +
      ", city='" + city + '\'' +
      ", state='" + state + '\'' +
      ", zipCode='" + zipCode + '\'' +
      '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Publisher)) return false;

    Publisher publisher = (Publisher) o;

    return id != null ? id.equals(publisher.id) : publisher.id == null;
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }

}
