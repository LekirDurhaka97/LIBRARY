package com.microlink.firstTime.domain;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    /*@Column(name = "author_id", nullable = false)
    private Long authorId;*/

    //@NotNull
    @Column(name = "title", length = 255, nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "id")
    private AuthorEntity authorEntity;

    public BookEntity(Long id, String title, AuthorEntity authorEntity) {
        this.id = id;
        this.title = title;
        this.authorEntity = authorEntity;
    }

    public BookEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public AuthorEntity getAuthorEntity() {
        return authorEntity;
    }

    public void setAuthorEntity(AuthorEntity authorEntity) {
        this.authorEntity = authorEntity;
    }
}
