package com.microlink.firstTime.domain;

import javax.persistence.*;

@Entity
@Table(name = "author")
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@NotNull
    @Column(name = "first_name", length = 255)
    private String firstName;

    //@NotNull
    @Column(name = "last_name", length = 255)
    private String lastName;

    /*@OneToMany(mappedBy = "id")
    private List<BookEntity> bookEntity;*/

    public AuthorEntity(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public AuthorEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
