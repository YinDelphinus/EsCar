package com.escar.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalTime;

@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Service")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private final Long id;

    @Column(name = "name", length = 200, nullable = false)
    private String name;

    @Column(name = "company_id", nullable = false, updatable = false)
    private final Long companyId;

    @Column(name = "required_duration")
    private LocalTime requiredDuration;
}
