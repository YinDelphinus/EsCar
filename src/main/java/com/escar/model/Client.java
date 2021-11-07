package com.escar.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private final Long id;

    @Column(name = "name", length = 150)
    private String name;

    @Column(name = "registration_date", nullable = false, updatable = false)
    private final LocalDateTime registrationDate = LocalDateTime.now();

    @Column(name  = "phone_number", nullable = false, unique = true)
    //+380 xx-xx-xx-xxx
    private Integer phoneNumber;

    @Column(name = "registered_messangers_mask", nullable = false)
    private Integer registeredMessengersMask = 0;

    @Column(name = "preferred_messenger", nullable = false)
    private Messenger preferredMessenger;

    @Column(name = "language", nullable = false)
    private Language language = Language.RUSSIAN;
}
