package com.example.bookstore.service;

import com.example.bookstore.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    Book saveBook(Book book);
    // İsteğe bağlı olarak ek metotlar yazılabilir
}