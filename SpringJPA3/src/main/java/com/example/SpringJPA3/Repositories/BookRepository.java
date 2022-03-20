package com.example.SpringJPA3.Repositories;

import com.example.SpringJPA3.entities.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
}