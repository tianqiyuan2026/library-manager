package com.book.book_web.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.book.book_web.entity.Book;
import com.book.book_web.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController{
    @Autowired 
    private BookService bookService;
    @GetMapping
    public List<Book> list(){return bookService.findAll();}
    @GetMapping("/find")
    public Book findByUid(  @RequestParam(required=false) Integer uid,
                            @RequestParam(required=false) String name){
        if(uid != null) return bookService.findOneWithUid(uid);
        if(name !=null) return bookService.findOneWithName(name);
        return null;
    }
    @PostMapping
    public void addBook(@RequestBody Book book){
        bookService.addOne(book);
    }
    @DeleteMapping("/{uid}")
    public void deleteBook(@PathVariable int uid){
        bookService.deleteOne(uid);
    }
}