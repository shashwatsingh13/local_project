package com.api.book.bootapibook.dao;

import org.springframework.data.repository.CrudRepository;

import com.api.book.bootapibook.Entities.Book;
//import java.util.List;


public interface BookRepository extends CrudRepository<Book,Integer> {

    public Book findbyBook(int id);
}
