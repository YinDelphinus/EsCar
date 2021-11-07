package com.escar.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Facility")
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private final Long id;

    @Column(name = "company_id", nullable = false, updatable = false)
    private final Long companyId;

    @ManyToMany
    @JoinTable(name = "facility_services",
            joinColumns = @JoinColumn(name = "facility_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id"))
    private List<Service> services;
}
