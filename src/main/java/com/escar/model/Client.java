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
    @Column(name  = "phone_number")
    //+380 xx-xx-xx-xxx
    private final Integer phoneNumber;

    @Column(name = "name", length = 150)
    private String name;

    @Column(name = "registration_date", nullable = false, updatable = false)
    private final LocalDateTime registrationDate = LocalDateTime.now();

    @Column(name = "registered_messangers_mask", nullable = false)
    private Integer registeredMessengersMask = 0;

    @Column(name = "preferred_messenger", nullable = false)
    private Messenger preferredMessenger;

    @Column(name = "language", nullable = false)
    private Language language = Language.RUSSIAN;
}
