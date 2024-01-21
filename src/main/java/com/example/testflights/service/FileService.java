package com.example.testflights.service;

import com.example.testflights.dto.TicketRequestDTO;
import com.example.testflights.exception.BadFormatFileException;
import com.example.testflights.mapper.TicketMapper;
import com.example.testflights.model.TicketWrapper;
import com.example.testflights.repository.TicketRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FileService {

    private final TicketRepository ticketRepository;
    private final TicketMapper ticketMapper;

    public void fillTable(MultipartFile initialFile) throws BadFormatFileException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            var root = mapper.readValue(initialFile.getInputStream(), TicketWrapper.class);
            List<TicketRequestDTO> ticketRequestDTOS = root.getTickets();
            var tickets = ticketMapper.ticketDTOsListToTicketList(ticketRequestDTOS);
            ticketRepository.saveAll(tickets);
        } catch (Exception e) {
            throw new BadFormatFileException("Something wrong with structure of file");
        }
    }
}
