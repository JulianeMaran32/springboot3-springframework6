package com.juhmaran.spring6webapp.book.domain;

import com.juhmaran.spring6webapp.author.domain.Author;
import com.juhmaran.spring6webapp.publisher.domain.Publisher;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Juliane Maran
 *
 * @since 29/05/2025
 */
@Entity
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  private String isbn;

  @ManyToMany
  @JoinTable(
    name = "author_book",
    joinColumns = @JoinColumn(name = "book_id"),
    inverseJoinColumns = @JoinColumn(name = "author_id"))
  private Set<Author> authors = new HashSet<>();

  @ManyToOne
  private Publisher publisher;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public Set<Author> getAuthors() {
    return authors;
  }

  public void setAuthors(Set<Author> authors) {
    this.authors = authors;
  }

  public Publisher getPublisher() {
    return publisher;
  }

  public void setPublisher(Publisher publisher) {
    this.publisher = publisher;
  }

  @Override
  public String toString() {
    return "Book{" +
      "id=" + id +
      ", title='" + title + '\'' +
      ", isbn='" + isbn + '\'' +
      ", authors=" + authors +
      '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Book)) return false;

    Book book = (Book) o;

    return getId() != null ? getId().equals(book.getId()) : book.getId() == null;
  }

  @Override
  public int hashCode() {
    return getId() != null ? getId().hashCode() : 0;
  }

}
