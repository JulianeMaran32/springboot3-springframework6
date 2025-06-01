// Em src/main/java/com/juhmaran/spring6webapp/services/
// Crie uma nova Classe Java chamada BookServiceImpl
package com.juhmaran.spring6webapp.book.services;

import com.juhmaran.spring6webapp.book.domain.Book;
import com.juhmaran.spring6webapp.book.repositories.BookRepository;
import org.springframework.stereotype.Service; // Importe a anotação @Service

@Service // Diz ao Spring para gerenciar esta classe como um Serviço
public class BookServiceImpl implements BookService {

  // Precisamos do Repositório de Livros para buscar os dados
  private final BookRepository bookRepository;

  // Construtor para que o Spring "injet" o BookRepository
  public BookServiceImpl(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  // Implementação do metodo da interface
  @Override
  public Iterable<Book> findAll() {
    // Chama o metodo findAll do repositório para buscar todos os livros
    return bookRepository.findAll();
  }

}


