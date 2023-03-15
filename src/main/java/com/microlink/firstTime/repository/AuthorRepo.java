package com.microlink.firstTime.repository;

import com.microlink.firstTime.domain.AuthorEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorRepo extends CrudRepository<AuthorEntity, Long> {

    List<AuthorEntity> findAll();

    Optional<AuthorEntity> findById(Long id);

}
