package com.example.testflights.mapper;

import com.example.testflights.dto.TicketRequestDTO;
import com.example.testflights.model.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TicketMapper {
    @Mapping(target = "departure", expression = "java(getDate(ticketRequestDTO.getDepartureDate(), ticketRequestDTO.getDepartureTime()))")
    @Mapping(target = "arrival", expression = "java(getDate(ticketRequestDTO.getArrivalDate(), ticketRequestDTO.getArrivalTime()))")
    Ticket ticketDtoToTicket(TicketRequestDTO ticketRequestDTO);

    List<Ticket> ticketDTOsListToTicketList(List<TicketRequestDTO> ticketRequestDTOS);

    default Date getDate(String date, String time) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yy HH:mm");
        try {
            return dateFormat.parse(date + " " + time);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
