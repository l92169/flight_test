package com.example.testflights.dto;


import com.example.testflights.model.enums.Location;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.Transient;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class TicketRequestDTO {
    private String origin;

    @JsonAlias("origin_name")
    private String originName;

    private Location destination;

    @JsonAlias("destination_name")
    private String destinationName;


    @JsonAlias("departure_date")
    private String departureDate;

    @JsonAlias("departure_time")
    private String departureTime;

    @Transient
    @JsonAlias("arrival_date")
    private String arrivalDate;

    @JsonAlias("arrival_time")
    private String arrivalTime;

    private String carrier;
    private int stops;
    private int price;
}
