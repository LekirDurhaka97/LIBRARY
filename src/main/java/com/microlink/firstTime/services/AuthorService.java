package com.microlink.firstTime.services;

import com.microlink.firstTime.domain.AuthorEntity;
import com.microlink.firstTime.repository.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService implements IAuthorService{

    @Autowired
    private AuthorRepo authorRepo;

    public List<AuthorEntity> findAllAuthor() {
        List<AuthorEntity> authorEntity = authorRepo.findAll();
        return authorEntity;
    }

    public AuthorEntity findAuthorById(Long id) {
        return authorRepo.findById(id).orElse(null);
    }

    public AuthorEntity save(AuthorEntity authorEntity) {
        authorRepo.save(authorEntity);
        return authorEntity;
    }
    public boolean update(AuthorEntity authorEntity) {
        if (authorRepo.save(authorEntity) != null) {
            return true;
        }
        return false;
    }
    public void deleteAuthorById(Long id) {
        authorRepo.deleteById(id);
    }

}
