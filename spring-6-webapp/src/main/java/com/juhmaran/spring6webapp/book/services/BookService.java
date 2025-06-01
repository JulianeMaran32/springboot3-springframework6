// Em src/main/java/com/juhmaran/spring6webapp/services/
// Crie um novo pacote 'services'

// Crie uma Interface Java chamada BookService
package com.juhmaran.spring6webapp.book.services;

import com.juhmaran.spring6webapp.book.domain.Book;

public interface BookService {

  // Metodo para encontrar todos os livros
  // Retorna um Iterable (algo que pode ser percorrido, como uma lista) de objetos Book
  Iterable<Book> findAll();

}


