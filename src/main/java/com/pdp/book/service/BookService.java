package com.pdp.book.service;

import com.pdp.book.entity.Book;

import java.util.List;

public interface BookService {

    Book saveBook(Book book);

    List<Book> getAllBooks();

    Book getBookById(Long id);

    void deleteBookById(Long id);

    List<Book> searchByTitle(String text);

    List<Book> searchByDescription(String text);

    List<Book> searchByAuthor(String text);

    List<Book> searchByTextInTitleDescriptionOrAuthor(String text);
}
