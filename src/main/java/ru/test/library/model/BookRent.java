package ru.test.library.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "book_rents")
@Getter
@Setter
public class BookRent {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "renter_id")
    private Client renter;

    @Column
    private LocalDate rentDate;
}
