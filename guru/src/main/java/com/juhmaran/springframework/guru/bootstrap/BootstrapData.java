package com.juhmaran.springframework.guru.bootstrap;

import com.juhmaran.springframework.guru.domain.Author;
import com.juhmaran.springframework.guru.domain.Book;
import com.juhmaran.springframework.guru.repository.AuthorRepository;
import com.juhmaran.springframework.guru.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

  private final AuthorRepository authorRepository;
  private final BookRepository bookRepository;

  public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
  }

  @Override
  public void run(String... args) throws Exception {

    var eric = new Author();
    eric.setFirstName("Eric");
    eric.setLastName("Evans");

    var ddd = new Book();
    ddd.setTitle("Domain Driven Design");
    ddd.setIsbn("123456");

    Author ericSaved = authorRepository.save(eric);
    Book dddSaved = bookRepository.save(ddd);

    var rod = new Author();
    rod.setFirstName("Rod");
    rod.setLastName("Johnson");

    var noEJB = new Book();
    noEJB.setTitle("J2EE Development without EJB");
    noEJB.setIsbn("54757585");

    Author rodSaved = authorRepository.save(rod);
    Book noEJBSaved = bookRepository.save(noEJB);

    ericSaved.getBooks().add(dddSaved);
    rodSaved.getBooks().add(noEJBSaved);

    authorRepository.save(ericSaved);
    authorRepository.save(rodSaved);

    System.out.println("In Bootstrap");
    System.out.println("Author Count: " + authorRepository.count());
    System.out.println("Book Count: " + bookRepository.count());

  }
}
