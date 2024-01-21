package com.example.testflights.model;

import com.example.testflights.dto.TicketRequestDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TicketWrapper {
    private List<TicketRequestDTO> tickets;
}