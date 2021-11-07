package com.escar.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private final Long id;

    @Column(name = "name", length = 150, nullable = false)
    private String name;

    @Column(name = "registration_date", nullable = false, updatable = false)
    private final LocalDateTime registrationDate = LocalDateTime.now();

    @Column(name = "address", nullable = false, length = 150)
    private String address;

    @Column(name = "dgisURL", nullable = false)
    private String dgisURL;

    @Column(name = "working_hours_from", nullable = false)
    private LocalTime workingHoursFrom;

    @Column(name = "working_hours_to", nullable = false)
    private LocalTime workingHoursTo;

    @OneToMany(mappedBy = "companyId")
    private List<Service> services;

    @OneToMany(mappedBy = "companyId")
    private List<Facility> facilities;
}
