package com.example.testflights.model;

import com.example.testflights.model.enums.Carrier;
import com.example.testflights.model.enums.Location;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date departure;
    private Date arrival;
    @Enumerated(EnumType.STRING)
    private Location origin;
    private String originName;
    @Enumerated(EnumType.STRING)
    private Location destination;
    private String destinationName;
    @Enumerated(EnumType.STRING)
    private Carrier carrier;
    private int stops;
    private int price;
}
