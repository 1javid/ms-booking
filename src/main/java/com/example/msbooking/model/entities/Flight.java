package com.example.msbooking.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "flight")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long flightNumber;
    private LocalDate departureTime;
    private String origin;
    @ElementCollection
    @CollectionTable(name = "flight_destinations", joinColumns = @JoinColumn(name = "flight_id"))
    @Column(name = "destination")
    private List<String> destinations;
    private Float amount;
}
