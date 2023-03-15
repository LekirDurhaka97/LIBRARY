package com.microlink.firstTime.domain;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@NotNull
    @Column(name = "title", length = 255, nullable = false)
    private String title;

    /*@ManyToOne
    @JoinColumn(name = "id")
    private BookEntity book;*/

    public BookEntity(Long id, String title) {
        this.id = id;
        this.title = title;
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
}
