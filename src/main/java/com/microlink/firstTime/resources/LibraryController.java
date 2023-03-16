package com.microlink.firstTime.resources;

import com.microlink.firstTime.domain.AuthorEntity;
import com.microlink.firstTime.domain.BookEntity;
import com.microlink.firstTime.repository.AuthorRepo;
import com.microlink.firstTime.services.IAuthorService;
import com.microlink.firstTime.services.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/library")
public class LibraryController {


    @Autowired
    private IAuthorService iAuthorService;

    @Autowired
    private IBookService iBookService;
    @Autowired
    private AuthorRepo authorRepo;

    ////////////////////////////////
    ///////   AUTHOR CRUD   ////////
    ////////////////////////////////
    @GetMapping("/author")
    public List<AuthorEntity> findAllAuthor() {
        List<AuthorEntity> authors = iAuthorService.findAll();
        return authors;
    }
    @GetMapping("/viewAuthor/{id}")
    public AuthorEntity getAuthorById(@PathVariable Long id) {
        return iAuthorService.findAuthorById(id);
    }
    @PostMapping("/newAuthor")
    public AuthorEntity save(@RequestBody AuthorEntity authorEntity) {
        return iAuthorService.save(authorEntity);
    }
    @PutMapping("/updateAuthor")
    public ResponseEntity<?> updateProduct(@RequestBody AuthorEntity authorEntity) {
        if (iAuthorService.update(authorEntity)) {
            return ResponseEntity.ok("Author updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating Author");
        }
    }
    @DeleteMapping("/deleteAuthor/{id}")
    public void deleteAuthorById(@PathVariable Long id) {
        iAuthorService.deleteAuthorById(id);
    }



    ////////////////////////////////
    ///////    BOOK CRUD    ////////
    ////////////////////////////////
    @GetMapping("/book")
    public List<BookEntity> findAllBook() {
        List<BookEntity> authors = iBookService.findAllBook();
        return authors.stream()
                .peek(author -> {
                    author.setTitle(author.getTitle().toUpperCase());
                })
                .collect(Collectors.toList());
    }
    @GetMapping("/viewBook/{id}")
    public BookEntity getBookById(@PathVariable Long id) {
        return iBookService.findBookById(id);
    }
    /*@GetMapping("/viewBookByAuthor/{author_id}")
    public BookEntity getBookByAuthorId(@PathVariable Long author_id) {
        return iBookService.findByAuthorEntity_Id(author_id);
    }*/
    @PostMapping("/newBook")
    public BookEntity save(@RequestBody BookEntity bookEntity) {
        return iBookService.save(bookEntity);
    }
    @DeleteMapping("/deleteBook/{id}")
    public void deleteBookById(@PathVariable Long id) {
        iBookService.deleteBookById(id);
    }
    @PutMapping("/updateBook")
    public ResponseEntity<?> updateProduct(@RequestBody BookEntity bookEntity) {
        if (iBookService.update(bookEntity)) {
            return ResponseEntity.ok("Book updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating book");
        }
    }



}
