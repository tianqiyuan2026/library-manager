package com.book.book_web.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.book_web.entity.Book;
import com.book.book_web.repository.BookRepository;
@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    public Book findOneWithUid(int uid){
        return bookRepository.findOneWithUid(uid);
    }

    public Book findOneWithName(String name){
        return bookRepository.findOneWithName(name);
    }

    public void deleteOne(int uid){
        bookRepository.deleteOne(uid);
    }

    public void addOne(Book book){
        bookRepository.addOne(book);
    }
}
