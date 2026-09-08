package com.book.book_web.repository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.book.book_web.entity.Book;
@Repository
public class BookRepository {
    @Autowired
    private JdbcTemplate jdbc;
    public List<Book> findAll(){
        return jdbc.query("select * from books",
        (rs,rowNum) -> new Book(rs.getInt("uid"),rs.getString("name")));
    }

    public Book findOneWithUid(int uid){
        return jdbc.queryForObject("select * from books where uid = ?", 
            (rs,rowNum) -> new Book(rs.getInt("uid"),rs.getString("name")),uid);
    }

    public Book findOneWithName(String name){
        return jdbc.queryForObject("select * from books where name = ?", 
            (rs,rowNum) -> new Book(rs.getInt("uid"),rs.getString("name")),name);
    }

    public void deleteOne(int uid){
        jdbc.update("delete from books where uid = ?",uid);
    }

    public void addOne(Book book){
        jdbc.update("insert into books (uid,name) values (?,?)",book.getUid(),book.getName());
    }
}
