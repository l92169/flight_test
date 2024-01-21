package com.example.testflights.service;

import java.util.List;

public interface StatisticsService {
    List<Object[]> getMinTimeForEachCarrier(String origin, String destination);

    Integer getDiffAvgMedian(String origin, String destination);

    void deleteTickets();
}
