package com.book.book_management.controller;

import com.book.book_management.service.BookService;
import com.book.book_management.model.Book;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {
    private final BookService bookService;
    public BookController(BookService bookService){
        this.bookService=bookService;
    }
    @GetMapping("/books")
    public List<Book> bookList(){
        return bookService.getAllBooks();
    }
    @PostMapping("/books")
    public String addBook(@RequestBody Book book){
        bookService.addBook(book);
        return "Book added successfully";
    }
    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable int id){
        return bookService.getBookById(id);
    }
    @PutMapping("/books/{id}")
    public Book updateBook(@PathVariable int id, @RequestBody Book updatedBook) {
        return bookService.updateBook(id, updatedBook);
    }
    @DeleteMapping("/books/{id}")
    public String deleteBook(@PathVariable int id){
        boolean deleted= bookService.deleteBook(id);
        if(deleted){
            return "book deleted Successfully";
        }
        return "Book not found";
    }
    @GetMapping("/books/author/{aut}")
    public List<Book> searchBook(@PathVariable String aut){
        return bookService.searchBook(aut);
    }
}
