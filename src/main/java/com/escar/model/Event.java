package com.escar.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private final Long id;

    @Column(name = "start_date_time")
    private final LocalDateTime startDateTime;

    @Column(name = "end_date_time")
    private final LocalDateTime endDateTime;

    @Column(name = "price", nullable = false, precision = 8, scale = 2)
    private Double price;

    @ManyToMany
    @JoinTable(name = "Events2Services",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id"))
    private Set<Service> services;

    @ManyToOne
    @org.hibernate.annotations.ForeignKey(name = "FK_Facility_Events")
    //while client reservation several events could be created
    // one per each facility needed for set of booked services
    private Facility facility;

    @ManyToOne
    @org.hibernate.annotations.ForeignKey(name = "FK_Client_Events")
    private Client client;
}
