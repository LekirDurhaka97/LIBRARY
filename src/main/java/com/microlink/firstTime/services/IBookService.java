package com.microlink.firstTime.services;

import com.microlink.firstTime.domain.AuthorEntity;
import com.microlink.firstTime.domain.BookEntity;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IBookService {

    List<BookEntity> findAllBook();

    BookEntity findBookById(Long id);

    //BookEntity findByAuthorEntity_Id(Long author_id);

    BookEntity save(BookEntity bookEntity);
    boolean update(BookEntity bookEntity);

    void deleteBookById(Long id);
}
