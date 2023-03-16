package com.microlink.firstTime.repository;

import com.microlink.firstTime.domain.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepo extends JpaRepository<BookEntity, Long> {

    List<BookEntity> findAll();

    Optional<BookEntity> findById(Long id);

    //BookEntity findByAuthorEntity_Id(Long author_id);

}
