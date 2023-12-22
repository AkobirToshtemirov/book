package com.pdp.book.repository;

import com.pdp.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleContainingIgnoreCase(String text);

    List<Book> findByDescriptionContainingIgnoreCase(String text);

    List<Book> findByAuthorContainingIgnoreCase(String text);

    @Query("SELECT b FROM Book b WHERE LOWER(b.title) LIKE LOWER(CONCAT('%', :text, '%')) OR LOWER(b.description) LIKE LOWER(CONCAT('%', :text, '%')) OR LOWER(b.author) LIKE LOWER(CONCAT('%', :text, '%'))")
    List<Book> searchByTextInTitleDescriptionOrAuthor(@Param("text") String text);
}