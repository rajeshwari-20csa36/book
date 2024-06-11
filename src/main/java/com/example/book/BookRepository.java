package com.example.book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookRepository {
    private List<Book> books = new ArrayList<>();
    private int currentId = 1;

    public Book create(Book book) {
        book.setId(currentId++);
        books.add(book);
        return book;
    }

    public List<Book> findAll() {
        return books;
    }

    public Optional<Book> findById(int id) {
        return books.stream().filter(book -> book.getId() == id).findFirst();
    }

    public Book update(Book book) {
        findById(book.getId()).ifPresent(b -> {
            b.setTitle(book.getTitle());
            b.setAuthor(book.getAuthor());
        });
        return book;
    }

    public boolean delete(int id) {
        return books.removeIf(book -> book.getId() == id);
    }
}
