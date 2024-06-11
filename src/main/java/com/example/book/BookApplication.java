package com.example.book;

import java.util.Optional;

public class BookApplication {
    public static void main(String[] args) {
        BookController controller = new BookController();

      
        Book addedBook = controller.createBook("The legend", "Raji");
        System.out.println("Book Added:");
        printBookDetails(addedBook);
        

        Optional<Book> updatedBook = controller.updateBook(addedBook.getId(), "ultra legend", "Raji (Updated)");
        if (updatedBook.isPresent()) {
            System.out.println("Book Updated:");
            printBookDetails(updatedBook.get());
        }

        boolean isDeleted = controller.deleteBook(addedBook.getId());
        if (isDeleted) {
            System.out.println("Book Deleted Successfully");
        }

        
    }

    private static void printBookDetails(Book book) {
        System.out.println("ID: " + book.getId());
        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
    }
}
