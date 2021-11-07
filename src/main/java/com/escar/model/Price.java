package com.escar.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Service")
/**
 * Separate entity used only for calculations of the price
 * final price of the event saved in the event
 * without foreign key constraint
 */
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private final Long id;

    @Column(name = "price", nullable = false, precision = 8, scale = 2)
    private Double price;

    @Column(name = "start_date_time")
    private LocalDateTime startDateTime;

    @Column(name = "end_date_time")
    private LocalDateTime endDateTime;

    @ManyToMany
    @JoinTable(name = "services_price",
            joinColumns = @JoinColumn(name = "facility_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id"))
    private List<Service> services;
}
