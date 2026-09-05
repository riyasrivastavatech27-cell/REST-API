package com.book.book_management.service;
import com.book.book_management.model.Book;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class BookService {
    public final List<Book> books=new CopyOnWriteArrayList<>();
public void addBook(Book book){
    books.add(book);
}
    public List<Book> getAllBooks(){
    return books;
    }
    public Book getBookById(int id){
    for(Book book:books){
        if(book.getId()==id){
            return book;
        }
    }
    return null;
    }
    public Book updateBook(int id,Book updatedBook){
    for(Book book:books){
        if(book.getId()==id){
            book.setAuthor(updatedBook.getAuthor());
            book.setId(updatedBook.getId());
            book.setPrice(updatedBook.getPrice());
            book.setTitle(updatedBook.getTitle());
        }
    }
    return null;
    }
    public boolean deleteBook(int id){
    for(Book  book :books){
        if(book.getId()==id){
            books.remove(book);
            return true;
        }
    }
    return false;
    }
    public List<Book> searchBook(String aut ){
    List <Book> result=new ArrayList<>();
    for(Book book:books){
        if(book.getAuthor().equals(aut)){
            result.add(book);
        }
    }
    return result;
    }
}
