package ru.test.library.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "clients")
@Getter
@Setter
public class Client {

    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private String name;

    @Column
    private String middleName;

    @Column
    private String lastName;

    @Column
    private LocalDate birthdate;
}
