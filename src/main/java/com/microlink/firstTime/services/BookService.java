package com.microlink.firstTime.services;

import com.microlink.firstTime.domain.AuthorEntity;
import com.microlink.firstTime.domain.BookEntity;
import com.microlink.firstTime.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService{

    @Autowired
    private BookRepo bookRepo;

    public List<BookEntity> findAllBook() {
        List<BookEntity> bookEntity = bookRepo.findAll();
        return bookEntity;
    }

    public BookEntity findBookById(Long id) {
        return bookRepo.findById(id).orElse(null);
    }

    public BookEntity findByAuthorEntity_Id(Long author_id) {
        return bookRepo.findByAuthorEntity_Id(author_id);
    }

    public BookEntity save(BookEntity bookEntity) {
        bookRepo.save(bookEntity);
        return bookEntity;
    }
    public boolean update(BookEntity bookEntity) {
        if (bookRepo.save(bookEntity) != null) {
            return true;
        }
        return false;
    }
    public void deleteBookById(Long id) {
        bookRepo.deleteById(id);
    }

}
