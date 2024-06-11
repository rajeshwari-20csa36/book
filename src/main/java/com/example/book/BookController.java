package com.example.book;

import java.util.List;
import java.util.Optional;

public class BookController {
    private BookRepository repository = new BookRepository();

    public Book createBook( String title, String author) {
        Book book = new Book( title, author);
        book = repository.create(book);
        addHateoasLinks(book);
        return book;
    }

    
    public List<Book> getAllBooks() {
        List<Book> books = repository.findAll();
        addHateoasLinks(books);
        return books;
    }

    public Optional<Book> getBookById(int id) {
        Optional<Book> book = repository.findById(id);
        book.ifPresent(this::addHateoasLinks);
        return book;
    }

    public Optional<Book> updateBook(int id, String title, String author) {
        Optional<Book> book = repository.findById(id);
        book.ifPresent(b -> {
            b.setTitle(title);
            b.setAuthor(author);
            repository.update(b);
            addHateoasLinks(b);
        });
        return book;
    }

    public boolean deleteBook(int id) {
        return repository.delete(id);
    }

    private void addHateoasLinks(Book book) {
        // Add self link
        System.out.println("Link: /books/" + book.getId());
        // Add update link
        System.out.println("Link: /books/" + book.getId() + "/update");
        // Add delete link
        System.out.println("Link: /books/" + book.getId() + "/delete");
    }

    private void addHateoasLinks(List<Book> books) {
        books.forEach(this::addHateoasLinks);
    }
}
