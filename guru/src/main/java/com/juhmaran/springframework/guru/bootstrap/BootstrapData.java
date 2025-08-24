package com.juhmaran.springframework.guru.bootstrap;

import com.juhmaran.springframework.guru.domain.Author;
import com.juhmaran.springframework.guru.domain.Book;
import com.juhmaran.springframework.guru.domain.Publisher;
import com.juhmaran.springframework.guru.repository.AuthorRepository;
import com.juhmaran.springframework.guru.repository.BookRepository;
import com.juhmaran.springframework.guru.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

  private final AuthorRepository authorRepository;
  private final BookRepository bookRepository;
  private final PublisherRepository publisherRepository;

  public BootstrapData(AuthorRepository authorRepository,
                       BookRepository bookRepository,
                       PublisherRepository publisherRepository) {
    this.authorRepository = authorRepository;
    this.bookRepository = bookRepository;
    this.publisherRepository = publisherRepository;
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
    dddSaved.getAuthors().add(ericSaved);
    noEJBSaved.getAuthors().add(rodSaved);

    var publisher = new Publisher();
    publisher.setPublisherName("My Publisher");
    publisher.setAddress("123 Main");
    Publisher savedPublisher = publisherRepository.save(publisher);

    dddSaved.setPublisher(savedPublisher);
    noEJBSaved.setPublisher(savedPublisher);

    authorRepository.save(ericSaved);
    authorRepository.save(rodSaved);
    bookRepository.save(dddSaved);
    bookRepository.save(noEJBSaved);

    System.out.println("In Bootstrap");
    System.out.println("Author Count: " + authorRepository.count());
    System.out.println("Book Count: " + bookRepository.count());



    System.out.println("Publisher Count: " + publisherRepository.count());

  }

}
