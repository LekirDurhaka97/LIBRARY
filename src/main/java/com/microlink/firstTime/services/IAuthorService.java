package com.microlink.firstTime.services;

import com.microlink.firstTime.domain.AuthorEntity;

import java.util.List;

public interface IAuthorService {

    List<AuthorEntity> findAllAuthor();

    AuthorEntity findAuthorById(Long id);

    AuthorEntity save(AuthorEntity authorEntity);

    boolean update(AuthorEntity authorEntity);

    void deleteAuthorById(Long id);


}
