package com.example.goodreads;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.ArrayList;
import com.example.goodreads.BookService;
import com.example.goodreads.Book;

@RestController
public class BookController{

    BookService bookService = new BookService();
    @GetMapping("/books")
    public ArrayList<Book> getBooks()
    {
       return bookService.getBooks();
    }

    @GetMapping("/books/{bookId}")
    public Book getBookById(@PathVariable("bookId") int bookId){
        return bookService.getBookById(bookId);
    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book){
        // System.out.println(book.getId());
        // System.out.println(book.getName());
        // System.out.println(book.getImageUrl());
        return bookService.addBook(book);
    }

    @PutMapping("/books/{bookId}")
    public Book updateBook(@PathVariable("bookId") int bookId, @RequestBody Book book)
    {
        return bookService.updateBook(bookId, book);
    }
    
    @DeleteMapping("/books/{bookId}")
    public void deleteBook(@PathVariable("bookId") int bookId)
    {
        bookService.deleteBook(bookId);
    }
}