package ru.test.library.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "book_rents")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rent extends AbstractEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "renter_id")
    private Client renter;

    @Column
    private LocalDate rentDate;
}
