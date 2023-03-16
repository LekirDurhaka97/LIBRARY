package com.microlink.firstTime.services;

import com.microlink.firstTime.domain.AuthorEntity;
import com.microlink.firstTime.repository.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService implements IAuthorService{

    @Autowired
    private AuthorRepo authorRepo;

    public List<AuthorEntity> findAll() {
        AuthorEntity author = new AuthorEntity();
        List<AuthorEntity> authorEntity = authorRepo.findAll();
        /*return authorEntity.stream()
                .peek(author -> {
                    author.setFirstName(author.getFirstName().toUpperCase());
                    author.setLastName(author.getLastName().toUpperCase());
                })
                .collect(Collectors.toList());*/
        authorEntity.forEach(x -> {
            x.setLastName(x.getLastName().toUpperCase());
            x.setFirstName(x.getFirstName().toUpperCase());
        });
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
