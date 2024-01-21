package com.example.testflights.service;

import com.example.testflights.repository.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StatisticsServiceImpl implements StatisticsService {
    private TicketRepository ticketRepository;

    public List<Object[]> getMinTimeForEachCarrier(String origin, String destination) {
        return ticketRepository.getTicketsWithMinTime(origin, destination);
    }

    public Integer getDiffAvgMedian(String origin, String destination) {
        return ticketRepository.getDiffAvgAndMedian(origin, destination);
    }

    @Override
    public void deleteTickets() {
        ticketRepository.deleteAll();
    }
}
