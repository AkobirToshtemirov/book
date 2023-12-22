package com.pdp.book.service.impl;

import com.pdp.book.repository.BookRepository;
import com.pdp.book.entity.Book;
import com.pdp.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> searchByTitle(String text) {
        return bookRepository.findByTitleContainingIgnoreCase(text);
    }

    @Override
    public List<Book> searchByDescription(String text) {
        return bookRepository.findByDescriptionContainingIgnoreCase(text);
    }

    @Override
    public List<Book> searchByAuthor(String text) {
        return bookRepository.findByAuthorContainingIgnoreCase(text);
    }

    @Override
    public List<Book> searchByTextInTitleDescriptionOrAuthor(String text) {
        return bookRepository.searchByTextInTitleDescriptionOrAuthor(text);
    }
}
