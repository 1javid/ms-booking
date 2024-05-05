package com.example.msbooking.repository;

import com.example.msbooking.model.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    @Query("SELECT f FROM Flight f JOIN f.destination d WHERE f.origin = :origin AND d = :destination AND f.departureTime = :departureTime")
    List<Flight> findByOriginAndDestinationAndDepartureTime(
            @Param("origin") String origin,
            @Param("destination") String destination,
            @Param("departureTime") LocalDate departureTime);
}