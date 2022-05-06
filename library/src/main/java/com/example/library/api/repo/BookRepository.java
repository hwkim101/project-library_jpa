package com.example.library.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.library.api.entity.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity ,Integer>{

}
