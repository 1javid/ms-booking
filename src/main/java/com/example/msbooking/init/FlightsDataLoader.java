package com.example.msbooking.init;

import com.example.msbooking.model.entities.Flight;
import com.example.msbooking.repository.FlightRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class FlightsDataLoader implements CommandLineRunner {
    private final FlightRepository flightRepository;
    public FlightsDataLoader(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if(flightRepository.findAll() == null) {
            List<String> origins = Arrays.asList("New York JFK", "London Heathrow", "Dubai International", "Tokyo Haneda", "Los Angeles LAX");
            List<String> destinations = Arrays.asList("Paris CDG", "Shanghai Pudong", "Singapore Changi", "Hong Kong International", "Sydney Kingsford");
            Random random = new Random();
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

            for (int i = 1; i <= 50; i++) {
                String origin = origins.get(random.nextInt(origins.size()));
                List<String> destination = Arrays.asList(destinations.get(random.nextInt(destinations.size())));

                Flight flight = Flight.builder()
                        .flightNumber(1000L + i)
                        .departureTime(LocalDate.now().plusDays(random.nextInt(30))) // Departures within the next 30 days
                        .origin(origin)
                        .destinations(destination)
                        .amount(100.0f + random.nextFloat() * 500) // Pricing between $100 and $600
                        .build();

                flightRepository.save(flight);
            }
        }
    }
}