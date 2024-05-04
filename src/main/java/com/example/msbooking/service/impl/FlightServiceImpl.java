package com.example.msbooking.service.impl;

import com.example.msbooking.model.dto.FlightDTO;
import com.example.msbooking.model.entities.Flight;
import com.example.msbooking.model.entities.FlightSearch;
import com.example.msbooking.repository.FlightRepository;
import com.example.msbooking.service.FlightService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;

    FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public FlightDTO getFlightById(Long id) {
        var flight = flightRepository.findById(id).get();

        return FlightDTO.builder()
                .id(flight.getId())
                .amount(flight.getAmount())
                .build();
    }

    @Override
    public List<Flight> searchFlights(FlightSearch searchCriteria) {
        return flightRepository.findByOriginAndDestinationAndDepartureTime(
                searchCriteria.getOrigin(), searchCriteria.getDestination(), searchCriteria.getDepartureDate());
    }
}